package com.example.android.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score = 0;
    int correctAnswer1 = 15;  //sum of first five natural numbers

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void grader(View view) {

        EditText answerOneText = (EditText) findViewById(R.id.answer_one);
        int answer_one = Integer.parseInt(answerOneText.getText().toString());
        score =  getScore(answer_one);

        Context context = getApplicationContext();
        CharSequence text = "score is :" +score;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }


    public int getScore(int answer_one) {
        if (answer_one == correctAnswer1) {
            score = score + 1;
        }
        return score;
    }
}