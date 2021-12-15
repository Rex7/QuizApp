package com.example.simplequiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.simplequiz.roomdb.Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuizSection extends AppCompatActivity {
    RecyclerView recyclerView;
    QuestionAdapter questionAdapter;
    Button submitQuiz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_section);
        recyclerView=findViewById(R.id.quizRecycler);
        ArrayList<Quiz> quizList=  getIntent().getParcelableArrayListExtra("listOfCategory");

        questionAdapter=new QuestionAdapter(quizList);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(questionAdapter);
        submitQuiz=findViewById(R.id.Submit);
        submitQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (Map.Entry<Integer,String> entry : questionAdapter.getAllSelectedValue().entrySet())
                    Log.v("HashMap" ,"key"+entry.getKey()+", Value = " + entry.getValue());
                Intent i =new Intent(getApplicationContext(),Results.class);
                i.putExtra("hashmap",questionAdapter.getAllSelectedValue());
                i.putParcelableArrayListExtra("answerList",quizList);
                startActivity(i);

            }
        });
    }
    public ArrayList<Quiz> addQuiz(){
        ArrayList<Quiz> quizzes=new ArrayList<>();
        return  quizzes;
    }
}