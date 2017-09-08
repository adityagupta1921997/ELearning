package com.apkglobal.elearning.Activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.apkglobal.elearning.Helper.Configure;
import com.apkglobal.elearning.R;
import com.daimajia.easing.Skill;
import com.wang.avi.AVLoadingIndicatorView;
import com.yarolegovich.lovelydialog.LovelyStandardDialog;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Quiz extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton optionOne,optionTwo,optionThree,optionFour,radioButton;
    private TextView questionName;
    String question_name;
    String option1,option2,option3,option4,correct;
    Button next_question,pre_question;
    int first_question_index=0,score=0,maximum_question;
    Configure tmhconf;
    AVLoadingIndicatorView avi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionName = (TextView) findViewById(R.id.question_name);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        optionOne = (RadioButton) findViewById(R.id.answerOne);
        optionTwo = (RadioButton) findViewById(R.id.answerOne);
        optionThree = (RadioButton) findViewById(R.id.answerOne);
        optionFour = (RadioButton) findViewById(R.id.answerOne);
        next_question = (Button) findViewById(R.id.button_next_question);
        pre_question = (Button) findViewById(R.id.button_previous_question);
        // avi=(AVLoadingIndicatorView)findViewById(R.id.avi);

        pre_question.setVisibility(View.INVISIBLE);

        next_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioGroup.getCheckedRadioButtonId() >= 0) {

                    int selectedId = radioGroup.getCheckedRadioButtonId();
                    radioButton = (RadioButton) findViewById(selectedId);

                    if (correct.equals(radioButton.getText())) {
                        score++;
                    }

                    pre_question.setVisibility(View.VISIBLE);
                    first_question_index++;
                    FetchLists fetchLists = new FetchLists();
                    fetchLists.execute(10, 0);
                } else {
                    new LovelyStandardDialog(Quiz.this)
                            .setTopColorRes(R.color.background_color)
                            .setButtonsColorRes(R.color.background_color)
                            .setIcon(R.drawable.alert)
                            .setTitle("Please Select an Option")
                            .setNegativeButton("OK", null)
                            .show();
                }

                if (first_question_index == maximum_question) {
                    new LovelyStandardDialog(Quiz.this)
                            .setTopColorRes(R.color.background_color)
                            .setButtonsColorRes(R.color.background_color)
                            .setIcon(R.drawable.alert)
                            .setTitle("Submission Quiz")
                            .setPositiveButton("Submit", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    String string_score= String.valueOf(score);
                                    String string_maximum_question= String.valueOf(maximum_question);

                                    Intent intent = new Intent (Quiz.this, Result.class);
                                    intent.putExtra("score", string_score);
                                    intent.putExtra("maximumQuestion", string_maximum_question);
                                    startActivity(intent);

                                }
                            })
                            .setNegativeButton(android.R.string.no, new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {


                                }
                            })
                            .show();

                }
            }
        });

        pre_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (first_question_index == 0) {
                    pre_question.setVisibility(View.INVISIBLE);
                    score = 0;

                } else {
                    pre_question.setVisibility(View.VISIBLE);
                    first_question_index--;
                    FetchLists fetchLists = new FetchLists();
                    fetchLists.execute(10, 0);
                    if (score > 0) {
                        score--;
                    } else {
                        score = 0;
                    }
                }
            }
        });
        FetchLists fetchLists = new FetchLists();
        fetchLists.execute(10, 0);


    }

    public class FetchLists extends AsyncTask<Integer, Void, String> {

        @Override
        protected String doInBackground(Integer... params) {
            String urlString = tmhconf.getFetch_url();

            try {
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                InputStream stream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                String line = reader.readLine();
                String response = "";
                while (line != null) {
                    response += line;
                    line = reader.readLine();
                }

                JSONObject object = new JSONObject(response);
                JSONArray jsonArray = object.getJSONArray("data");

                JSONObject list = (JSONObject) jsonArray.get(first_question_index);

                question_name= list.getString("Question");
                option1=list.getString("A1");
                option2=list.getString("A2");
                option3=list.getString("A3");
                option4=list.getString("A4");
                correct=list.getString("CorrectAnswer");
                maximum_question =jsonArray.length();


            } catch (Exception e) {
                e.printStackTrace();
            }
            return "quiz";
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            questionName.setText(question_name);

            ((RadioButton) radioGroup.getChildAt(0)).setText(option1);
            ((RadioButton) radioGroup.getChildAt(1)).setText(option2);
            ((RadioButton) radioGroup.getChildAt(2)).setText(option3);
            ((RadioButton) radioGroup.getChildAt(3)).setText(option4);

        }

    }

}
