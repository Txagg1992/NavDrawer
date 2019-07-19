package com.curiousca.navdrawerbuild;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new FoodMenuFragment()).commit();
        }
    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)){
            mDrawer.isDrawerOpen(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    private void initViews(){

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.nav_menu_items:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FoodMenuFragment()).commit();
                break;
            case R.id.nav_order_food:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new OrderFoodFragment()).commit();
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Share this App", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_contact:
                Toast.makeText(this, "Contact us for no apparent reason", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_chat:
                Toast.makeText(this, "Send a text, Let's chat", Toast.LENGTH_SHORT).show();
                break;
        }
        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
