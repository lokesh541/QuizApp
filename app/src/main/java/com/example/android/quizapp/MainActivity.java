package com.example.android.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score = 0;
    String correctAnswer1 = "15";  //sum of first five natural numbers
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void grader(View view) {

        EditText answerOneText = (EditText) findViewById(R.id.answer_one);
        String answer_one = answerOneText.getText().toString().trim();

        RadioButton radioButton = (RadioButton) findViewById(R.id.question_2_option_3);
        boolean checked = radioButton.isChecked();

        score = getScore(answer_one,checked);
        Context context = getApplicationContext();
        CharSequence text = "score is :" +score;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }
     private  int getScore(String answer_one,boolean checked) {

         if (answer_one.equals(correctAnswer1)) {
             score = score + 1;
         }
         if (checked){
             score = score+1;
         }

         return  score;
     }
}