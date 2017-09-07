package com.apkglobal.elearning.Helper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.apkglobal.elearning.Activity.MainActivity;


public class Shared {
    Context context;
    SharedPreferences sp;
    SharedPreferences.Editor ed;
    int mode = 0;
    String filename = "meri";
    String login = "login";

    public Shared(Context context) {
        this.context = context;
        sp = context.getSharedPreferences(filename, mode);
        ed = sp.edit();
    }

    public void withoutlogin() {
        if (!this.islogin())
        {
            Intent i=new Intent(context,MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(i);
        }
    }

    public void withlogin()
    {
        ed.putBoolean(login,true);
        ed.commit();
    }

    private boolean islogin() {
        return sp.getBoolean(login,false);
    }
}

