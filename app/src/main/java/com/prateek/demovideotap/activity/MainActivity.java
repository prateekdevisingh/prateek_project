package com.prateek.demovideotap.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.prateek.demovideotap.R;
import com.prateek.demovideotap.adapter.HomeContentAdapter;
import com.prateek.demovideotap.utility.Utility;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {


    private CardView cvContent;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        initializeView();
    }

    private void initializeView() {
        AppCompatImageView ivSearch = (AppCompatImageView)findViewById(R.id.ivSearch);
        ivSearch.setOnClickListener(this);

        createDynamicContent();
    }

    private void createDynamicContent() {

        for(int index = 0 ; index < 4 ; index++){
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.rlContent);
            cvContent = new CardView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 600);
            layoutParams.setMargins(40,40,40,40);
            cvContent.setLayoutParams(layoutParams);
            cvContent.setRadius(12);
            cvContent.setContentPadding(10,10,10,10);
            cvContent.setCardBackgroundColor(Color.parseColor("#FFC6D6C3"));
            cvContent.setMaxCardElevation(5);
            cvContent.setCardElevation(12);
            cvContent.setLayoutParams(layoutParams);
            TextView textView = new TextView(this);
            //textView.setLayoutParams(layoutParams);
            textView.setText(String.valueOf(index));
            textView.setTextSize(16);
            textView.setTextColor(Color.BLUE);
            textView.setGravity(Gravity.CENTER);

            cvContent.addView(textView);
            linearLayout.addView(cvContent);
            if (index == 1){
                for (int index1 = 0 ; index1 < 1 ; index1++){
                    LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
                    View viewCenterContent = layoutInflater.inflate(R.layout.home_content_layout, null);
                    Button button = new Button(this);
                    LinearLayout.LayoutParams lpForCenterContent = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300);
                    lpForCenterContent.setMargins(40, 40, 40, 40);
                    button.setText(String.valueOf(index1));
                    button.setTextSize(16);

                    recyclerView = (RecyclerView) viewCenterContent.findViewById(R.id.recyclerViewContent);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
                    HomeContentAdapter homeContentAdapter = new HomeContentAdapter(this, index1);
                    recyclerView.setAdapter(homeContentAdapter);
                    button.setLayoutParams(lpForCenterContent);
                    linearLayout.addView(viewCenterContent);

                }

            }

        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if(id == R.id.first){
            startActivity(new Intent(this, MultipleRoleActivity.class));
            overridePendingTransition(R.anim.anim_in_left_from_right, R.anim.anim_in_right_from_left);
            return true;
        } else if(id == R.id.second){
            startActivity(new Intent(this, ItemPageActivity.class));
            overridePendingTransition(R.anim.anim_in_left_from_right, R.anim.anim_in_right_from_left);
            return true;
        } else if(id == R.id.third){
            return  true;
        } else if(id == R.id.forth){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ivSearch:
                Utility.openSearch(findViewById(R.id.toolbar), this);
                break;
        }
    }
}
