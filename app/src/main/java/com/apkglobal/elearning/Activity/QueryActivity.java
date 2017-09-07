package com.apkglobal.elearning.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.apkglobal.elearning.R;

public class QueryActivity extends AppCompatActivity {
    Button btn_submit;
    EditText et_query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        btn_submit=(Button)findViewById(R.id.btn_submit);
        et_query=(EditText)findViewById(R.id.et_query);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_query.setText("");
                Toast.makeText(QueryActivity.this, "Your Query is submitted...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
