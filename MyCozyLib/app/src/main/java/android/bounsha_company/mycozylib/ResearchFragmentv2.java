package android.bounsha_company.mycozylib;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ResearchFragmentv2 extends Fragment
{
    RecyclerView bookList;
    BookAdapter_v2 bookAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View currentView = inflater.inflate(R.layout.fragment_research, container, false);

        bookList = currentView.findViewById(R.id.recycler_view_books_list);
        bookList.hasFixedSize();
        bookList.setLayoutManager(new LinearLayoutManager(this.getContext()));

        // attach an adapter to the RecyclerView
        bookAdapter = new BookAdapter_v2();
        bookList.setAdapter(bookAdapter);

        return currentView;
    }
}
