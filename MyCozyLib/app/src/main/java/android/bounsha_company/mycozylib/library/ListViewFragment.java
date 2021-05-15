package android.bounsha_company.mycozylib.library;

import android.bounsha_company.mycozylib.R;
import android.bounsha_company.mycozylib.recyclerView.BookListAdapter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListViewFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View currentView = inflater.inflate(R.layout.fragment_list_view, container, false);

        // set the recycler views that contain all the books
        RecyclerView recyclerView = currentView.findViewById(R.id.recycler_view_library_books_list);
        BookListAdapter adapter = new BookListAdapter(new BookListAdapter.BookDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(currentView.getContext()));

        return currentView;
    }
}
