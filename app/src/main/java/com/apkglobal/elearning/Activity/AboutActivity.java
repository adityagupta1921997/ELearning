package com.apkglobal.elearning.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.apkglobal.elearning.R;

public class AboutActivity extends AppCompatActivity {
    TextView tv_about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        tv_about=(TextView)findViewById(R.id.tv_about);
    }
}
