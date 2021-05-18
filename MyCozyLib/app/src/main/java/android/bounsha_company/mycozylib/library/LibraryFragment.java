package android.bounsha_company.mycozylib.library;

import android.bounsha_company.mycozylib.R;
import android.bounsha_company.mycozylib.models.Book;
import android.bounsha_company.mycozylib.recyclerView.BookAdapter;
import android.bounsha_company.mycozylib.viewModel.BookViewModel;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

public class LibraryFragment extends Fragment{

    public static final int NEW_BOOK_ACTIVITY_REQUEST_CODE = 1;
    private BookViewModel bookViewModel;
    private RecyclerView recyclerView;

    /**
     * onCreateView : initialize the new Vew
     * @param inflater : #TODO
     * @param container : ViewGroup : the group where the new view will be added
     * @param savedInstanceState : #TODO
     * @return View : the new View
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        // initialize the view
        View currentView = inflater.inflate(R.layout.fragment_library, container, false);

        // initialize book list
        inflateLibraryBookList(currentView);

        //initialize bottom navigation
        BottomNavigationView bottomNav = currentView.findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        // initialize floating action button
        FloatingActionButton fab = currentView.findViewById(R.id.fab_library);
        fab.setOnClickListener( view ->
        {
            Intent intent = new  Intent(currentView.getContext(), AddNewBookActivity.class );
            startActivityForResult(intent, NEW_BOOK_ACTIVITY_REQUEST_CODE);
        });

        return currentView;
    }

    /**
     * inflateLibraryBookList : initialize the book list
     * @param currentView : View : currentView
     */
    private void inflateLibraryBookList(View currentView)
    {
        // set the recycler views that contains all the books
        recyclerView = (RecyclerView) currentView.findViewById(R.id.recycler_view_library_books_list);
        BookAdapter adapter = new BookAdapter(new BookAdapter.BookDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        // #TODO : delete this, it only was here for testing
        bookViewModel = new ViewModelProvider(getActivity()).get(BookViewModel.class);
        bookViewModel.getBookList().observe(getViewLifecycleOwner(), books ->
        {
            // update the cached copy of the books in the adapter
            adapter.submitList(books);
        });
    }

    //set an action when a specified item of the menu is clicked
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item)
                {
                    switch (item.getItemId())
                    {
                        case R.id.nav_list_view:
                            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
                            break;
                        case R.id.nav_grid_view:
                            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
                            break;
                        case R.id.nav_image_view:
                            Fragment selectedFragment = new ImageViewFragment();
                            getFragmentManager().beginTransaction().replace(R.id.fragment_library_view_container, selectedFragment).commit();
                            break;
                    }
                    return true;
                }
            };

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
