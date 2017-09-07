package com.apkglobal.elearning.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.apkglobal.elearning.Fragments.Login_Fragment;
import com.apkglobal.elearning.R;
import static com.apkglobal.elearning.Helper.Utils.Login_Fragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            getSupportFragmentManager().beginTransaction().add(R.id.frameContainer,new Login_Fragment(),Login_Fragment).commit();
    }

    public void replaceLoginFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameContainer,new Login_Fragment(),Login_Fragment).commit();

    }
}
