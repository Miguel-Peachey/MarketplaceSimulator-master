package com.miguelpeachey.marketplacesimulator.Activities;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.miguelpeachey.marketplacesimulator.Fragments.AboutFragment;
import com.miguelpeachey.marketplacesimulator.Fragments.MarketplaceFragment;
import com.miguelpeachey.marketplacesimulator.Fragments.ProfileFragment;
import com.miguelpeachey.marketplacesimulator.Fragments.SellFragment;
import com.miguelpeachey.marketplacesimulator.Fragments.SettingsFragment;
import com.miguelpeachey.marketplacesimulator.Fragments.SuppliersFragment;
import com.miguelpeachey.marketplacesimulator.R;
import com.miguelpeachey.marketplacesimulator.Services.TrendBroadcastReceiver;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static Context contextOfApplication;
    SharedPreferences imageSharedPreferences, sharedPreferences;

    TextView textMailItemCount;
    int mailItemCount = 0;

    PendingIntent pendingIntent;
    Intent intent;
    AlarmManager alarmManager;

    public static Context getContextOfApplication() {
        return contextOfApplication;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        final TextView tvDrawerUsername = headerView.findViewById(R.id.tvDrawerUsername);
        final ImageView ivNavHeader = headerView.findViewById(R.id.ivNavHeader);
        setSupportActionBar(toolbar);

        contextOfApplication = getApplicationContext();


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawer,
                toolbar,
                R.string.nav_open_drawer,
                R.string.nav_close_drawer) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                // Do whatever you want here
            }

            private boolean opened;

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);

                if (slideOffset == 0) {
                    opened = false;
                } else {
                    if (!opened) {
                        opened = true;

                        sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
                        final String usernameID = sharedPreferences.getString("name", "User");
                        tvDrawerUsername.setText(String.valueOf(usernameID));

                        imageSharedPreferences = getSharedPreferences("imagePrefs", Context.MODE_PRIVATE);
                        final String imageID = imageSharedPreferences.getString("image", "7");

                        if (imageID.equals(String.valueOf("1"))) {
                            ivNavHeader.setImageResource(R.drawable.casual_man);
                        } else if (imageID.equals(String.valueOf("2"))) {
                            ivNavHeader.setImageResource(R.drawable.formal_man);
                        } else if (imageID.equals(String.valueOf("3"))) {
                            ivNavHeader.setImageResource(R.drawable.glasses_man);
                        } else if (imageID.equals(String.valueOf("4"))) {
                            ivNavHeader.setImageResource(R.drawable.brunette_woman);
                        } else if (imageID.equals(String.valueOf("5"))) {
                            ivNavHeader.setImageResource(R.drawable.blonde_woman);
                        } else if (imageID.equals(String.valueOf("6"))) {
                            ivNavHeader.setImageResource(R.drawable.short_woman);
                        } else if (imageID.equals(String.valueOf("7"))) {
                            ivNavHeader.setImageResource(R.drawable.blank_avatar);
                        }
                    }
                }
            }
        };

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        Fragment fragment = new MarketplaceFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.content_frame, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();
        Fragment fragment;

        switch (id) {
            case R.id.nav_buy:

                fragment = new MarketplaceFragment();

                break;

            case R.id.nav_sell:

                fragment = new SellFragment();

                break;

            case R.id.nav_suppliers:

                fragment = new SuppliersFragment();

                break;

            case R.id.nav_profile:

                fragment = new ProfileFragment();

                break;

            case R.id.nav_settings:

                fragment = new SettingsFragment();

                break;

            case R.id.nav_about:

                fragment = new AboutFragment();

                break;

            default:

                fragment = new MarketplaceFragment();

        }

        if (fragment != null) {

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

            ft.replace(R.id.content_frame, fragment);

            ft.commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.menu_notification, menu);

        SharedPreferences countPrefs = getSharedPreferences("countPrefs", MODE_PRIVATE);
        mailItemCount = countPrefs.getInt("count", 60);

        final MenuItem menuItem = menu.findItem(R.id.mail);

        View actionView = MenuItemCompat.getActionView(menuItem);
        textMailItemCount = actionView.findViewById(R.id.cart_badge);

        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOptionsItemSelected(menuItem);
            }
        });

        setupBadge();

        return super.onCreateOptionsMenu(menu);
    }

    private void setupBadge() {

        if (textMailItemCount != null) {
            if (mailItemCount == 0) {
                if (textMailItemCount.getVisibility() != View.GONE) {
                    textMailItemCount.setVisibility(View.GONE);
                }
            } else {
                textMailItemCount.setText(String.valueOf(Math.min(mailItemCount, 99)));
                if (textMailItemCount.getVisibility() != View.VISIBLE) {
                    textMailItemCount.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.mail) {

            Intent intent = new Intent(MainActivity.this, MailActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(menuItem);
    }

    public void startAlertAtTime() {

        intent = new Intent(this, TrendBroadcastReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 0,
                intent, PendingIntent.FLAG_CANCEL_CURRENT);

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.setInexactRepeating(AlarmManager.RTC, 5000,
                60000, pendingIntent);
    }

}
