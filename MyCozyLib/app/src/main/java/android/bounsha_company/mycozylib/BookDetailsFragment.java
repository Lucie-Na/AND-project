package android.bounsha_company.mycozylib;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BookDetailsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View currentView = inflater.inflate(R.layout.fragment_book_details, container, false);
        ImageButton buttonBack = currentView.findViewById(R.id.btn_book_details_back);
        buttonBack.setOnClickListener(v ->
        {

        });
        return currentView;
    }
}
