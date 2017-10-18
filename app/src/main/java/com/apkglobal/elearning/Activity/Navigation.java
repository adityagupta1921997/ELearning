package com.apkglobal.elearning.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.apkglobal.elearning.Adapters.ImageSliderAdapter;
import com.apkglobal.elearning.Helper.Helper;
import com.apkglobal.elearning.Helper.Shared;
import com.apkglobal.elearning.R;
import com.apkglobal.elearning.SkillUtil.SkillAdapter;

import java.util.Timer;
import java.util.TimerTask;

public class Navigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ViewPager imageSliderViewPager;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;
    RecyclerView recyclerView;
    Shared shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        shared=new Shared(getApplicationContext());
        shared.withoutlogin();
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Navigation.this, "Give Your feedback after using this app!!", Toast.LENGTH_LONG).show();
                Intent feedback=new Intent(Intent.ACTION_VIEW);
                feedback.setData(Uri.parse("https://play.google.com"));
                startActivity(feedback);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView_categories);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SkillAdapter skillAdapter=new SkillAdapter();
        recyclerView.setAdapter(skillAdapter);

        sliderDotspanel=(LinearLayout)findViewById(R.id.imageSliderDots);
        imageSliderViewPager=(ViewPager)findViewById(R.id.imageSlider);
        ImageSliderAdapter imageSliderAdapter=new ImageSliderAdapter(this);
        imageSliderViewPager.setAdapter(imageSliderAdapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new AutoSlider(), 2000, 4000);

        dotscount = imageSliderAdapter.getCount();
        dots = new ImageView[dotscount];

        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        imageSliderViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        Helper h=new Helper(this);
        h.checkLogin();
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
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.logout) {
            new Helper(this).logout();
            startLogin();
            Toast.makeText(getApplicationContext(),"Logout...",Toast.LENGTH_SHORT).show();

        }

        return true;
    }

    private void startLogin() {
        Intent toLogin=new Intent(Navigation.this,MainActivity.class);
        startActivity(toLogin);
        finish();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
        } else if (id == R.id.about) {
            Intent about=new Intent(Navigation.this,AboutActivity.class);
            startActivity(about);

        } else if (id == R.id.query) {
            Intent query=new Intent(Navigation.this,QueryActivity.class);
            startActivity(query);

        }
        else if (id == R.id.nav_share) {
            Intent share=new Intent(Intent.ACTION_SEND);
            share.putExtra(Intent.EXTRA_TEXT,
                    "Hey check out my app at: https://play.google.com");
            share.setType("text/plain");
            startActivity(Intent.createChooser(share,"Share App Via"));

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public class AutoSlider extends TimerTask {
        @Override
        public void run() {
            Navigation.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (imageSliderViewPager.getCurrentItem() == 0) {
                        imageSliderViewPager.setCurrentItem(1);
                    } else if (imageSliderViewPager.getCurrentItem() == 1) {
                        imageSliderViewPager.setCurrentItem(2);
                    }
                    else if (imageSliderViewPager.getCurrentItem() == 2) {
                        imageSliderViewPager.setCurrentItem(3);
                    }
                    else if (imageSliderViewPager.getCurrentItem() == 3) {
                        imageSliderViewPager.setCurrentItem(4);
                    }
                    else {
                        imageSliderViewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}
