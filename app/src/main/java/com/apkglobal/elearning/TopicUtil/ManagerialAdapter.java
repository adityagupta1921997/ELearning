package com.apkglobal.elearning.TopicUtil;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apkglobal.elearning.R;

import java.util.ArrayList;
import java.util.List;


public class ManagerialAdapter extends RecyclerView.Adapter<ManagerialHolder> {

    private List<ManagerialModel> managerialModels;
    private final View.OnClickListener btListner;

    public ManagerialAdapter(View.OnClickListener butListner)
    {
        this.btListner=butListner;
        managerialModels =new ArrayList<>();
        managerialModels.add(new ManagerialModel("1.Team Management"));
        managerialModels.add(new ManagerialModel("2.Time Management"));
        managerialModels.add(new ManagerialModel("3.Stress Management"));


    }

    @Override
    public ManagerialHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.abc_layout_topics,parent,false);
        return new ManagerialHolder(view,btListner);

    }

    @Override
    public void onBindViewHolder(ManagerialHolder holder, int position) {

        ManagerialModel skillModel= managerialModels.get(position);
        holder.bindData(skillModel);
    }

    @Override
    public int getItemCount() {
        return managerialModels.size();
    }
}
