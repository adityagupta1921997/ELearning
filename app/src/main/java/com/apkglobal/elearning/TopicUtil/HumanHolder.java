package com.apkglobal.elearning.TopicUtil;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.apkglobal.elearning.Activity.Quiz;
import com.apkglobal.elearning.Activity.YoutubeActivity;
import com.apkglobal.elearning.Helper.Configure;
import com.apkglobal.elearning.R;

class HumanHolder extends RecyclerView.ViewHolder {

    private TextView topicName;
    Context context;
    private Button quiz_button;
    Configure configure3=new Configure();
    String[] hvideo1={"pf2ROqiFYLs","osEYfI3JK50","V0OOYR1-_vA"};
    String[] hvideo2={"xmOQa_KiuPE","IbNMhxVrpp8"};
    String hurl1="http://aptronnoida.com/Aditya_July4/Demo/COM_FETCH.php";
    String hurl2="http://aptronnoida.com/Aditya_July4/Demo/INTER_FETCH.php";

    public HumanHolder(final View itemView, View.OnClickListener listener) {
        super(itemView);
        context=itemView.getContext();

        topicName=(TextView) itemView.findViewById(R.id.name_of_topic);
        quiz_button=(Button) itemView.findViewById(R.id.button_quiz_section);
        quiz_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (connectionStatus() == true) {
                    if (getAdapterPosition() == 1) {
                        configure3.setFetch_url(hurl1);
                    } else {
                        configure3.setFetch_url(hurl2);
                    }
                    Intent tquiz = new Intent(context, Quiz.class);
                    context.startActivity(tquiz);
                }
                else {
                    Toast.makeText(context, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        });
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (connectionStatus() == true) {
                    if (getAdapterPosition() == 0) {
                        configure3.setVideokey(hvideo1);
                    } else {
                        configure3.setVideokey(hvideo2);
                    }
                    Intent intent = new Intent(context, YoutubeActivity.class);
                    context.startActivity(intent);
                }
                else {
                    Toast.makeText(context, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void bindData(HumanModel skillModel)
    {
        topicName.setText(skillModel.topic_name);
    }
    private boolean connectionStatus() {
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            return true;
        }
        else
            return false;
    }
}
