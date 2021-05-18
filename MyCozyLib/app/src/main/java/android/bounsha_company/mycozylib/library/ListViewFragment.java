package android.bounsha_company.mycozylib.library;

import android.bounsha_company.mycozylib.MainActivity;
import android.bounsha_company.mycozylib.R;
import android.bounsha_company.mycozylib.models.Book;
import android.bounsha_company.mycozylib.recyclerView.BookAdapter;
import android.bounsha_company.mycozylib.viewModel.BookViewModel;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class ListViewFragment extends Fragment
{
    private BookViewModel bookViewModel;
    public static final int NEW_BOOK_ACTIVITY_REQUEST_CODE = 1;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View currentView = inflater.inflate(R.layout.fragment_list_view, container, false);

        // set the recycler views that contain all the books
        RecyclerView recyclerView = (RecyclerView) currentView.findViewById(R.id.recycler_view_library_books_list);
        BookAdapter adapter = new BookAdapter(new BookAdapter.BookDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        bookViewModel = new ViewModelProvider(getActivity()).get(BookViewModel.class);
        ArrayList<Book> bookList = new ArrayList<Book>();
        Book book = new Book("test", "test", "test", "test", 0, "test", 0, "test");
        bookViewModel.insert(book);
        bookList.add(book);
        adapter.submitList(bookList);
        /*bookViewModel.getBookList().observe(getViewLifecycleOwner(), books ->
        {
            // update the cached copy of the books in the adapter
            adapter.submitList(books);
        });*/

        return currentView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == NEW_BOOK_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK)
        {
            Book book = new Book("test", "test", "test", "test", 2021, "test", 0, "" );
                    //data.getStringExtra(AddNewBookActivity.EXTRA_REPLY));
            bookViewModel.insert(book);
        }
        else
        {
            Toast.makeText(getContext(), R.string.book_empty_not_saved, Toast.LENGTH_SHORT).show();
        }
    }
}
