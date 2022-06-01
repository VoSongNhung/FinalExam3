package com.example.finalexam3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.finalexam3.fragment.AddFragment;
import com.example.finalexam3.fragment.ListFragment;
import com.example.finalexam3.fragment.SearchFragment;
import com.google.android.material.navigation.NavigationView;

public class Nav_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private static final int FRAGMENT_LIST = 0;
    private static final int FRAGMENT_ADD = 1;
    private static final int FRAGMENT_SEARCH = 2;
    private int currentFragment = FRAGMENT_LIST;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawerlayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        replaceFragment(new com.example.finalexam3.fragment.ListFragment());
        navigationView.getMenu().findItem(R.id.nav_list).setChecked(true);
        /*Test*/
        View v = navigationView.getHeaderView(0);
        TextView TV_Name = (TextView) v.findViewById(R.id.tv_NameUser);
        TV_Name.setText(getIntent().getStringExtra("User"));
        /*EndTest*/
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_list) {
            if (currentFragment != FRAGMENT_LIST) {
                replaceFragment(new ListFragment());
                currentFragment = FRAGMENT_LIST;
                NavigationView navigationView = findViewById(R.id.nav_view);
                navigationView.getMenu().findItem(R.id.nav_list).setChecked(true);
                navigationView.getMenu().findItem(R.id.nav_add).setChecked(false);
                navigationView.getMenu().findItem(R.id.nav_search).setChecked(false);
            }
        } else if (id == R.id.nav_add) {
            if (currentFragment != FRAGMENT_ADD) {
                replaceFragment(new AddFragment());
                currentFragment = FRAGMENT_ADD;
                NavigationView navigationView = findViewById(R.id.nav_view);
                navigationView.getMenu().findItem(R.id.nav_list).setChecked(false);
                navigationView.getMenu().findItem(R.id.nav_add).setChecked(true);
                navigationView.getMenu().findItem(R.id.nav_search).setChecked(false);
            }
        } else if (id == R.id.nav_search) {
            if (currentFragment != FRAGMENT_SEARCH) {
                replaceFragment(new SearchFragment());
                currentFragment = FRAGMENT_SEARCH;
                NavigationView navigationView = findViewById(R.id.nav_view);
                navigationView.getMenu().findItem(R.id.nav_list).setChecked(false);
                navigationView.getMenu().findItem(R.id.nav_add).setChecked(false);
                navigationView.getMenu().findItem(R.id.nav_search).setChecked(true);
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, fragment);
        transaction.commit();
    }
}