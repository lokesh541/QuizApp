package com.example.android.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score = 0;


    String correctAnswer1 = "15"; //answer for the First question
    String correctAnswer5 = "2"; // answer for the Fifth question

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }







    public void grader(View view) {

        //Response for the first question
        EditText answerField = (EditText) findViewById(R.id.question_1_answer);
        String question_1_ans = answerField.getText().toString().trim();

        RadioButton question_2 = (RadioButton) findViewById(R.id.question_2_option_3); // response for the second question
        boolean question_2_ans = question_2.isChecked();

        // checks whether two correct answers are selected
        CheckBox optionOneChecked = (CheckBox) findViewById(R.id.question_3_option_1);
        boolean option_1_Checked = optionOneChecked.isChecked();
        CheckBox optionThreeChecked = (CheckBox) findViewById((R.id.question_3_option_3));
        boolean option_3_checked = optionThreeChecked.isChecked();

        //correct response for the fourth question
        RadioButton question_4 = (RadioButton) findViewById(R.id.question_4_option_2);
        boolean question_4_checked = question_4.isChecked();

        //respose of the fifth question
        EditText question_5 = (EditText) findViewById(R.id.question_5);
        String answer_5 = question_5.getText().toString().trim();

        // Method to calculate
        score = getScore(question_1_ans, question_2_ans, option_1_Checked, option_3_checked, question_4_checked, answer_5);

        //Toast to display the total score score
        Context context = getApplicationContext();
        CharSequence text = "score is :" + score;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

    private int getScore(String question_1_ans, boolean checked,
                         boolean option_1_checked, boolean option_3_checked,
                         boolean question_4_checked, String answer_5) {

        if (question_1_ans.equals(correctAnswer1)) {
            score = score + 1;
        }
        if (checked) {
            score = score + 1;
        }

        if (option_1_checked && option_3_checked) {
            score = score + 1;
        }

        if (question_4_checked) {
            score = score + 1;
        }

        if (answer_5.equals(correctAnswer5)) {
            score = score + 1;
        }

        return score;
    }
}