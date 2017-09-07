package com.apkglobal.elearning.TopicUtil;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apkglobal.elearning.R;

import java.util.ArrayList;
import java.util.List;


public class TechnicalAdapter extends RecyclerView.Adapter<TechnicalHolder> {

    private List<TechnicalModel> technicalModels;
    private final View.OnClickListener btListner;

    public TechnicalAdapter(View.OnClickListener butListner)
    {
        this.btListner=butListner;
        technicalModels =new ArrayList<>();
        technicalModels.add(new TechnicalModel("1.Coding And Programming"));
        technicalModels.add(new TechnicalModel("2.Big Data Analytics"));
        technicalModels.add(new TechnicalModel("3.Project Management"));
        technicalModels.add(new TechnicalModel("4.Technical Writing"));


    }

    @Override
    public TechnicalHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.abc_layout_topics,parent,false);
        return new TechnicalHolder(view,btListner);

    }

    @Override
    public void onBindViewHolder(TechnicalHolder holder, int position) {

        TechnicalModel skillModel= technicalModels.get(position);
        holder.bindData(skillModel);
    }

    @Override
    public int getItemCount() {
        return technicalModels.size();
    }
}
