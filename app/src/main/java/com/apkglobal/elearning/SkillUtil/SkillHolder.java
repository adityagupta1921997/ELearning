package com.apkglobal.elearning.SkillUtil;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/*import com.apkglobal.elearning.Activity.HumanSkills;
import com.apkglobal.elearning.Activity.ManagerialSkills;
import com.apkglobal.elearning.Activity.TechnicalSkills;*/
import com.apkglobal.elearning.Activity.HumanSkills;
import com.apkglobal.elearning.Activity.ManagerialSkills;
import com.apkglobal.elearning.Activity.TechnicalSkills;
import com.apkglobal.elearning.R;

class SkillHolder extends RecyclerView.ViewHolder {

    private TextView skillName;
    private ImageView skillImage;
    Context context;

    public SkillHolder(final View itemView) {
        super(itemView);
        context=itemView.getContext();

        skillImage=(ImageView)itemView.findViewById(R.id.image_of_skill);
        skillName=(TextView) itemView.findViewById(R.id.text_of_skill);
        itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (getAdapterPosition()==0)
        {

            context.startActivity(new Intent(context, TechnicalSkills.class));

        }
        else if (getAdapterPosition()==1)
        {

            context.startActivity(new Intent(context, ManagerialSkills.class));

        }
        else if(getAdapterPosition()==2){
            context.startActivity(new Intent(context, HumanSkills.class));
        }
    }
});

    }

    public void bindData(SkillModel skillModel)
    {
        skillName.setText(skillModel.name_of_skill);
        skillImage.setImageResource(skillModel.image_of_skill);
    }
}
