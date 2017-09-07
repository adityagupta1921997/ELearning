package com.apkglobal.elearning.TopicUtil;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apkglobal.elearning.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashu on 31/8/17.
 */

public class HumanAdapter extends RecyclerView.Adapter<HumanHolder> {

    private List<HumanModel> humanModels;
    private final View.OnClickListener btListner;

    public HumanAdapter(View.OnClickListener butListner)
    {
        this.btListner=butListner;
        humanModels =new ArrayList<>();
        humanModels.add(new HumanModel("1.Communication Skills"));
        humanModels.add(new HumanModel("2.Interpersonal Skills"));

    }

    @Override
    public HumanHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.abc_layout_topics,parent,false);
        return new HumanHolder(view,btListner);

    }

    @Override
    public void onBindViewHolder(HumanHolder holder, int position) {

        HumanModel skillModel= humanModels.get(position);
        holder.bindData(skillModel);
    }

    @Override
    public int getItemCount() {
        return humanModels.size();
    }
}
