package android.bounsha_company.mycozylib.library;

import android.bounsha_company.mycozylib.MainActivity;
import android.bounsha_company.mycozylib.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LibraryFragment extends Fragment{

    public static final int NEW_BOOK_ACTIVITY_REQUEST_CODE = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View currentView = inflater.inflate(R.layout.fragment_library, container, false);

        //create bottom navigation
        BottomNavigationView bottomNav = currentView.findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //default view : list view
        getFragmentManager().beginTransaction().replace(R.id.fragment_library_view_container, new ListViewFragment()).commit();

        FloatingActionButton fab = currentView.findViewById(R.id.fab_library);
        fab.setOnClickListener( view ->
        {
            Intent intent = new  Intent(currentView.getContext(), AddNewBookActivity.class );
            startActivityForResult(intent, NEW_BOOK_ACTIVITY_REQUEST_CODE);
        });

        return currentView;
    }

    //set an action when a specified item of the menu is clicked
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId())
                    {
                        case R.id.nav_list_view:
                            selectedFragment = new ListViewFragment();
                            break;
                        case R.id.nav_grid_view:
                            selectedFragment = new GridViewFragment();
                            break;
                        case R.id.nav_image_view:
                            selectedFragment = new ImageViewFragment();
                            break;
                    }
                    getFragmentManager().beginTransaction().replace(R.id.fragment_library_view_container, selectedFragment).commit();
                    return true;
                }
            };


}
