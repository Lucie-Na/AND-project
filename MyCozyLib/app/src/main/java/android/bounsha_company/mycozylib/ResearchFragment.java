package android.bounsha_company.mycozylib;

import android.bounsha_company.mycozylib.recyclerView.BookListAdapter;
import android.bounsha_company.mycozylib.database.api.BookViewModelAPI;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ResearchFragment extends Fragment
{
    private BookViewModelAPI bookViewModelAPI;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        super.onCreateView(inflater, container, savedInstanceState);

        View currentView = inflater.inflate(R.layout.fragment_research, container, false);
        EditText researchInputText = currentView.findViewById(R.id.text_input_research);
        ImageButton submitResearchButton = currentView.findViewById(R.id.img_btn_submit_research);
        ProgressBar progressBar = currentView.findViewById(R.id.progress_bar);
        Log.e("Debug", "Search Book : layouts initialize");

        bookViewModelAPI = new ViewModelProvider(getActivity()).get(BookViewModelAPI.class);
        bookViewModelAPI.getBookByName(researchInputText.getText().toString());
        Log.e("Debug", "Search Book : view model for API initializes");

        // initialize book list
        inflateLibraryBookList(currentView);

        // initialize on click listener to send the research
        submitResearchButton.setOnClickListener(v ->
        {
            Log.e("Debug", "Search Book : new research");
            progressBar.setVisibility(View.VISIBLE);

            // checking if research field is not empty
            if (!researchInputText.getText().toString().isEmpty())
            {
                Log.e("Debug", "Search Book : research not empty");
                // load the result
                bookViewModelAPI.getBookByName(researchInputText.getText().toString());
            }
            else
            {
                progressBar.setVisibility(View.GONE);
                researchInputText.setError("Please enter your research in the text field");
            }

        });
        Log.e("Debug", "Search Book : research button initialize");
        return currentView;
    }

    /**
     * inflateLibraryBookList : initialize the book list
     * @param currentView : View : currentView
     */
    private void inflateLibraryBookList(View currentView)
    {
        // set the recycler views that contains all the books
        RecyclerView recyclerView = currentView.findViewById(R.id.recycler_view_full_book_list);
        BookListAdapter adapter = new BookListAdapter(new BookListAdapter.BookDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        Log.e("Debug", "Search Book : recycler views initialize");

        // set an observer to update the database when a new book is created
        BookViewModelAPI viewModel = new ViewModelProvider(getActivity()).get(BookViewModelAPI.class);
        viewModel.getBook().observe(getViewLifecycleOwner(), books ->
        {
            // update the cached copy of the books in the adapter
            adapter.submitList(books);

        });
        Log.e("Debug", "Search Book : observer on API set up");
    }
}