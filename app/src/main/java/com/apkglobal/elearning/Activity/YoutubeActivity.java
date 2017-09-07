package com.apkglobal.elearning.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.apkglobal.elearning.Helper.Configure;
import com.apkglobal.elearning.R;
import com.apkglobal.elearning.Adapters.RecyclerAdapter;


public class YoutubeActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        //to use RecycleView, you need a layout manager. default is LinearLayoutManager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

            RecyclerAdapter adapter = new RecyclerAdapter(YoutubeActivity.this);
            recyclerView.setAdapter(adapter);

    }
}