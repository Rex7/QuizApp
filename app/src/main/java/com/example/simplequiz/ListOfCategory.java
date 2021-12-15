package com.example.simplequiz;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.simplequiz.roomdb.Quiz;
import com.example.simplequiz.roomdb.QuizDao;
import com.example.simplequiz.roomdb.QuizImp;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListOfCategory extends AppCompatActivity {
    RecyclerView recyclerView;
    CategoryRecyclerAdapter recyclerAdapter;
    QuizDao databaseHelper;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_category);
        recyclerView=findViewById(R.id.quizCategoryRecycler);
        databaseHelper= QuizImp.getDatabase(getApplicationContext()).quizDao();
        recyclerAdapter=new CategoryRecyclerAdapter(this,databaseHelper);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);
    }
}