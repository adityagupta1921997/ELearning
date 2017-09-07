package com.apkglobal.elearning.Fragments;

/**
 * Created by Mayank on 8/30/2017.
 */

import android.widget.Toast;

import com.apkglobal.elearning.Helper.CustomToast;
import com.apkglobal.elearning.R;

import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.view.ViewGroup;
import android.widget.EditText;
        import android.widget.TextView;


public class ForgotPassword_Fragment extends Fragment implements
        OnClickListener {
    private static View view;

    private static EditText emailId;
    private static TextView submit, back;

    public ForgotPassword_Fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.forgot_password_layout, container,
                false);
        initViews();
        setListeners();
        return view;
    }

    // Initialize the views
    private void initViews() {
        emailId = (EditText) view.findViewById(R.id.registered_emailid);
        submit = (TextView) view.findViewById(R.id.forgot_button);
        back = (TextView) view.findViewById(R.id.backToLoginBtn);

        // Setting text selector over textviews

            back.setTextColor(getResources().getColorStateList(R.color.textview_selector));
            submit.setTextColor(getResources().getColorStateList(R.color.textview_selector));

    }

    // Set Listeners over buttons
    private void setListeners() {
        back.setOnClickListener(this);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backToLoginBtn:
                getActivity().getSupportFragmentManager().popBackStack("BACK",0);

                // Replace Login Fragment on Back Presses
                /*new MainActivity().replaceLoginFragment();
                break;*/

            case R.id.forgot_button:

                // Call Submit button task
                submitButtonTask();
                break;

        }

    }

    private void submitButtonTask() {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String getEmailId = emailId.getText().toString();

       /* // Pattern for email id validation
        Pattern p = Pattern.compile(Utils.regEx);

        // Match the pattern
        Matcher m = p.matcher(getEmailId);*/

        // First check if email id is not null else show error toast
        if (getEmailId.equals("") || getEmailId.length() == 0)

            new CustomToast().Show_Toast(getActivity(), view,
                    "Please enter your Email Id.");

            // Check if email id is valid or not
        else if (!getEmailId.matches(emailPattern))
            new CustomToast().Show_Toast(getActivity(), view,
                    "Your Email Id is Invalid.");

            // Else submit email id and fetch passwod or do your stuff
        else
            Toast.makeText(getActivity(), "Get Forgot Password.",
                    Toast.LENGTH_SHORT).show();
    }
}