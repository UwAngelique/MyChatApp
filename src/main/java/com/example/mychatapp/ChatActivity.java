package com.example.mychatapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class ChatActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    private ActionBarDrawerToggle drawerToggle;
    NavigationView navigationView;
    ImageButton btnMenu;
    TextView textViewTittle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        //upportActionBar(toolbar);
        // This will display an Up icon (<-), we will replace it with hamburger later
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Find our drawer view
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_bar_item_icon_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle;
        toggle = new ActionBarDrawerToggle(this, drawer,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_container,
                    new Chatfragment()).commit();
            navigationView.setCheckedItem(R.id.nav_chat);
        }

        btnMenu = findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationView.setVisibility(View.VISIBLE);
            }
        });
        textViewTittle = findViewById(R.id.txtTitle);
    }

    public void setSupportActionBar(Toolbar toolbar) {
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_chat:
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_container,
                            new Chatfragment()).commit();
                    navigationView.setVisibility(View.GONE);
                    textViewTittle.setText("Chat");
                    break;
                case R.id.nav_status:
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_container,
                            new StatusFragment()).commit();
                    navigationView.setVisibility(View.GONE);
                    textViewTittle.setText("Status");
                    break;
                case R.id.nav_calls:
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_container,
                            new CallsFragment()).commit();
                    navigationView.setVisibility(View.GONE);
                    textViewTittle.setText("Calls");
                    break;
            case R.id.nav_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_send:
                Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
                break;
                default:
                    throw new IllegalStateException("Unexpected value: " + item.getItemId());
            }
            //drawer.closeDrawer(GravityCompat.START);
            return true;
        }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();
        }
    }
//    public void loadFragment(Fragment fragment) {
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.nav_host_fragment_container, fragment);
//        transaction.commit();
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//
//    }

}