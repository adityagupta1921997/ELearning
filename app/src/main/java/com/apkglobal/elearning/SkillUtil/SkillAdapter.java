package com.apkglobal.elearning.SkillUtil;

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

public class SkillAdapter extends RecyclerView.Adapter<SkillHolder> {

    private List<SkillModel> skillModelList;

    public SkillAdapter()
    {
        skillModelList=new ArrayList<>();
        skillModelList.add(new SkillModel("Technical", R.drawable.engineering_log));
        skillModelList.add(new SkillModel("Managerial",R.drawable.maanegerial));
        skillModelList.add(new SkillModel("Human",R.drawable.communication));
    }

    @Override
    public SkillHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.abc_category_skill,parent,false);
        return new SkillHolder(view);

    }

    @Override
    public void onBindViewHolder(SkillHolder holder, int position) {

        SkillModel skillModel=skillModelList.get(position);
        holder.bindData(skillModel);
    }

    @Override
    public int getItemCount() {
        return skillModelList.size();
    }
}
