package com.example.simplequiz.quiz;

import android.os.Bundle;

import com.example.simplequiz.R;
import com.example.simplequiz.roomdb.Quiz;
import com.example.simplequiz.roomdb.QuizDao;
import com.example.simplequiz.roomdb.QuizImp;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class QuizUpdated  extends AppCompatActivity {
    RecyclerView recyclerView;
    NewUpdatedAdapter newUpdatedAdapter;
    QuizDao databaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_quiz_section);
        recyclerView=findViewById(R.id.answer);
        ArrayList<Quiz> quizList=  getIntent().getParcelableArrayListExtra("listOfCategory");
        String category= (String) getIntent().getExtras().get("category");
        databaseHelper= QuizImp.getDatabase(getApplicationContext()).quizDao();

        newUpdatedAdapter=new NewUpdatedAdapter(getApplicationContext(),databaseHelper,quizList,category,recyclerView);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(newUpdatedAdapter);

    }
}
