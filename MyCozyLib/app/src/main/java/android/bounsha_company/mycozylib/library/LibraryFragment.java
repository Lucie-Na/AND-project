package android.bounsha_company.mycozylib.library;

import android.bounsha_company.mycozylib.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LibraryFragment extends Fragment{
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
