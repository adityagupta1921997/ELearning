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

import com.apkglobal.elearning.Activity.YoutubeActivity;
import com.apkglobal.elearning.Helper.Configure;
import com.apkglobal.elearning.R;

class TechnicalHolder extends RecyclerView.ViewHolder {

    private TextView topicName;
    Context context;
    private Button quiz_button;
    Configure configure=new Configure();
    String[] videoid1={"r59xYe3Vyks", "gzlhm0jco0g", "4ekASokneGU","qgMH6jOOFOE","ss7BtLrbxp4"};
    String[] videoid2={"zez2Tv-bcXY","mafw2-CVYnA","6H2e03tapfk","HOYOVB5MMRw","n3qnsVFNEIU"};
    String[] videoid3={"6Or_9IRQHi4","yW450TnhT54","JWW7G1zRzNg"};
    String[] videoid4={"mZk0DDbq4ec","jNZ1eSs1hSg","O75CfmrxxL4"};
    String turl1="http://aptronnoida.com/Aditya_July4/Demo/JAVA_FETCH.php";
    String turl2="http://aptronnoida.com/Aditya_July4/Demo/BIGDATA_FETCH.php";
    String turl3="http://aptronnoida.com/Aditya_July4/Demo/PROJECT_FETCH.php";
    String turl4="http://aptronnoida.com/Aditya_July4/Demo/TECH_FETCH.php";

    public TechnicalHolder(final View itemView, View.OnClickListener listener) {
        super(itemView);
        context = itemView.getContext();

        topicName = (TextView) itemView.findViewById(R.id.name_of_topic);
        quiz_button = (Button) itemView.findViewById(R.id.button_quiz_section);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(connectionStatus()==true) {
                    if (getAdapterPosition() == 0) {
                        configure.setVideokey(videoid1);
                    } else if (getAdapterPosition() == 1) {
                        configure.setVideokey(videoid2);

                    } else if (getAdapterPosition() == 2) {
                        configure.setVideokey(videoid3);

                    } else {
                        configure.setVideokey(videoid4);

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

    public void bindData(TechnicalModel skillModel)
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
