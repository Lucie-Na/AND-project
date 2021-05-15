package android.bounsha_company.mycozylib;

import android.bounsha_company.mycozylib.recyclerView.BookListAdapter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

import android.bounsha_company.mycozylib.models.Book;

public class ResearchFragment extends Fragment
{
    private ArrayList<Book> bookArrayList;
    private EditText researchInputText;
    private ProgressBar progressBar;
    private View currentView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        currentView = inflater.inflate(R.layout.fragment_research, container, false);

        researchInputText = currentView.findViewById(R.id.text_input_research);
        ImageButton submitResearchButton = currentView.findViewById(R.id.img_btn_submit_research);
        progressBar = currentView.findViewById(R.id.progress_bar);

        // initializing on click listener for our button.
        submitResearchButton.setOnClickListener(v ->
        {
            progressBar.setVisibility(View.VISIBLE);

            // checking if our edittext field is empty or not.
            if (researchInputText.getText().toString().isEmpty()) {
                progressBar.setVisibility(View.GONE);
                researchInputText.setError("Please enter your research in the text field");

                return;
            }
            // if the search query is not empty then we are
            // calling get book info method to load all
            // the books from the API.
            getBooksInfo(researchInputText.getText().toString());
        });

        return currentView;
    }

    private void getBooksInfo(String query)
    {
        bookArrayList = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
        requestQueue.getCache().clear();
        String url = "https://www.googleapis.com/books/v1/volumes?q=" + query;
        RequestQueue queue = Volley.newRequestQueue(getContext());

        JsonObjectRequest booksJsonRequest = new JsonObjectRequest(Request.Method.GET, url, null, (Response.Listener<JSONObject>) response -> {
            progressBar.setVisibility(View.GONE);
            // inside on response method we are extracting all our json data.
            try {
                JSONArray itemsArray = response.getJSONArray("items");
                for (int i = 0; i < itemsArray.length(); i++) {
                    JSONObject itemsObj = itemsArray.getJSONObject(i);
                    JSONObject volumeObj = itemsObj.getJSONObject("volumeInfo");

                    String title = volumeObj.optString("title");
                    String subtitle = volumeObj.optString("subtitle");
                    String publisher = volumeObj.optString("publisher");
                    int publishedDate = volumeObj.optInt("publishedDate");
                    String description = volumeObj.optString("description");
                    int pageCount = volumeObj.optInt("pageCount");
                    JSONObject imageLinks = volumeObj.optJSONObject("imageLinks");
                    //assert imageLinks != null;
                    String thumbnail = imageLinks.optString("thumbnail");
                    String previewLink = volumeObj.optString("previewLink");
                    String infoLink = volumeObj.optString("infoLink");
                    ArrayList<String> authorsArrayList = new ArrayList<>();
                    String stringAuthors = "";
                    for (String author : authorsArrayList)
                    {
                        stringAuthors += author + ", ";
                    }
                    // after extracting all the data we are
                    // saving this data in our modal class.
                    Book book = new Book(title, subtitle, stringAuthors, publisher, publishedDate, description, pageCount, thumbnail, previewLink, infoLink);

                    // below line is use to pass our modal
                    // class in our array list.
                    bookArrayList.add(book);

                    // below line is use to pass our
                    // array list in adapter class.
                    BookListAdapter adapter = new BookListAdapter(new BookListAdapter.BookDiff());

                    // below line is use to add linear layout
                    // manager for our recycler view.
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
                    RecyclerView mRecyclerView = (RecyclerView) currentView.findViewById(R.id.recycler_view_books_list);

                    // in below line we are setting layout manager and
                    // adapter to our recycler view.
                    mRecyclerView.setLayoutManager(linearLayoutManager);
                    mRecyclerView.setAdapter(adapter);
                }
            } catch (JSONException e)
            {
                e.printStackTrace();
                // displaying a toast message when we get any error from API
                Toast.makeText(getContext(), "No Data Found" + e, Toast.LENGTH_LONG).show();
            }
        }, (Response.ErrorListener) error -> Toast.makeText(getContext(), "Error found is " + error, Toast.LENGTH_SHORT).show());
        // at last we are adding our json object
        // request in our request queue.
        queue.add(booksJsonRequest);
    }
}
