package com.apkglobal.elearning.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.apkglobal.elearning.R;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

public class Result extends AppCompatActivity {

    KonfettiView viewKonfetti;
    TextView text_score, text_total_questions;
    String string_score_number, string_total_question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        viewKonfetti = (KonfettiView) findViewById(R.id.viewKonfetti);
        text_score = (TextView) findViewById(R.id.socre_scored);
        text_total_questions = (TextView) findViewById(R.id.total_questions);

        viewKonfetti.build()
                .addColors(Color.parseColor("#12fce6"), Color.parseColor("#ff0dc6c9"), Color.parseColor("#009688"))
                .setDirection(90.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(5000L)
                .addShapes(Shape.RECT, Shape.CIRCLE)
                .addSizes(new Size(14, 6f))
                .setPosition(-50f, viewKonfetti.getWidth() + 50f, -50f, -50f)
                .stream(300, 5000L);


        YoYo.with(Techniques.ZoomInDown)
                .duration(1000)
                .repeat(2)
                .playOn(text_score);

        YoYo.with(Techniques.ZoomInDown)
                .duration(1000)
                .repeat(2)
                .playOn(text_total_questions);
        Intent intent = getIntent();
        string_score_number = intent.getStringExtra("score");
        string_total_question = intent.getStringExtra("maximumQuestion");
        text_score.setText(string_score_number);
        text_total_questions.setText(" / " + string_total_question);

    }

}
