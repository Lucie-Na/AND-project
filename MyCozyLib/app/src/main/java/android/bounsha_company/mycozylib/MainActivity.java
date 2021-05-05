package android.bounsha_company.mycozylib;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create the toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //create the drawer
        drawer = findViewById(R.id.drawer_layout);
        NavigationView nv = findViewById(R.id.nav_view);
        nv.setNavigationItemSelectedListener(this);

        //drawer navigation
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //prevent from going back to the beginning page when rotates
        /*if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new MessageFragment()).commit();
            nv.setCheckedItem(R.id.nav_message);
        }*/
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;

        switch (item.getItemId())
        {
            case R.id.nav_library:
                selectedFragment = new LibraryFragment();
                break;
            case R.id.nav_wish_list:
                selectedFragment = new WishFragment();
                break;
            case R.id.nav_recommendations:
                selectedFragment = new RecommendationFragment();
                break;
            case R.id.nav_research:
                selectedFragment = new ResearchFragment();
                break;
            case R.id.nav_friends:
                selectedFragment = new FriendFragment();
                break;
            case R.id.nav_posts:
                selectedFragment = new PostFragment();
                break;
            case R.id.nav_settings:
                selectedFragment = new SettingFragment();
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_main_container, selectedFragment).commit();

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}