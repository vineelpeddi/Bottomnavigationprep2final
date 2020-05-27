package com.example.bottomnavigationprep2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.FavoritesFragment;
import com.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
           Fragment selectedFragment = null;

           switch(menuItem.getItemId()){
               case R.id.nav_home:
                   selectedFragment = new HomeFragment();
                   break;
               case R.id.nav_favorites:
                   selectedFragment = new FavoritesFragment();
                   break;
               case R.id.nav_search:
                   selectedFragment = new SearchFragment();
                   break;
           }
           getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                   selectedFragment).commit();

           return true;
        }
    };
}
