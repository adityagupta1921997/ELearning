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

class ManagerialHolder extends RecyclerView.ViewHolder {
    Configure configure2=new Configure();
    String[] mvideoid1={"PWmhl6rzVpM"};
    String[] mvideoid2={"b3fVtWfhitc"};
    String[] mvideoid3={"98e8O0jhzsA","uL_70mwlHio"};
    String murl1="http://aptronnoida.com/Aditya_July4/Demo/TEAM_FETCH.php";
    String murl2="http://aptronnoida.com/Aditya_July4/Demo/TIME_FETCH.php";
    String murl3="http://aptronnoida.com/Aditya_July4/Demo/STRESS_FETCH.php";

    private TextView topicName;
    Context context;
    private Button quiz_button;

    public ManagerialHolder(final View itemView, View.OnClickListener listener) {
        super(itemView);
        context=itemView.getContext();

        topicName=(TextView) itemView.findViewById(R.id.name_of_topic);
        quiz_button=(Button) itemView.findViewById(R.id.button_quiz_section);
        quiz_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (connectionStatus() == true) {

                    if (getAdapterPosition() == 0) {
                        configure2.setFetch_url(murl1);
                    } else if (getAdapterPosition() == 1) {
                        configure2.setFetch_url(murl2);
                    } else {
                        configure2.setFetch_url(murl3);
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
                        configure2.setVideokey(mvideoid1);
                    } else if (getAdapterPosition() == 1) {
                        configure2.setVideokey(mvideoid2);
                    } else {
                        configure2.setVideokey(mvideoid3);
                    }
                    Intent intent = new Intent(context, YoutubeActivity.class);
                    context.startActivity(intent);
                }
                else{
                    Toast.makeText(context, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void bindData(ManagerialModel skillModel)
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
