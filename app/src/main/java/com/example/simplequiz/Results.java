package com.example.simplequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.simplequiz.roomdb.Quiz;
import com.example.simplequiz.roomdb.QuizImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Results extends AppCompatActivity {
    TextView score,outOf;
    int position;

    int scoreValue=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        score=findViewById(R.id.score);
        outOf=findViewById(R.id.totalScore);
        String category= (String) getIntent().getExtras().get("category");
        HashMap<Integer,String> results= (HashMap<Integer, String>) getIntent().getExtras().get("answerList");
        ArrayList<Quiz> answerList = (ArrayList<Quiz>) QuizImp.getDatabase(getApplicationContext()).quizDao().getQuiz(category);
        outOf.setText(""+answerList.size());

        for (Map.Entry<Integer,String> entry : results.entrySet()) {

            Log.v("Results", "key" + entry.getKey() + ", Value = " + entry.getValue());


            if( answerList.get(position).getAnswer().contains(entry.getValue())){
                scoreValue++;
            }
            position++;
        }
        int percentage=scoreValue/answerList.size()*100;
        if(percentage<=33){
            score.setTextColor(Color.CYAN);
        }
        else if (percentage>=50){
            score.setTextColor(Color.GREEN);
        }
        score.setText(String.valueOf(scoreValue));

    }


}