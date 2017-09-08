package com.apkglobal.elearning.Activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.apkglobal.elearning.R;
import com.apkglobal.elearning.TopicUtil.HumanAdapter;
import com.apkglobal.elearning.TopicUtil.ManagerialAdapter;
import com.yarolegovich.lovelydialog.LovelyStandardDialog;

public class HumanSkills extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_human_skills);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"Playing the HumanSkills Video",Toast.LENGTH_SHORT).show();
                new LovelyStandardDialog(HumanSkills.this)
                        .setTopColorRes(R.color.background_color)
                        .setButtonsColorRes(R.color.background_color)
                        .setIcon(R.drawable.alert)
                        .setTitle("Get Set Go!!")
                        .setNegativeButton("OK", null)
                        .show();
            }
        });

//        quizButton=(Button)findViewById(R.id.button_quiz_section);

        View.OnClickListener butListner=new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        };

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView_topics_human);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        HumanAdapter humanAdapter =new HumanAdapter(butListner);
        recyclerView.setAdapter(humanAdapter);



    }

}
