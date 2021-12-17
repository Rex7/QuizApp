package com.example.simplequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.simplequiz.category.ListOfCategory;

public class MainActivity extends AppCompatActivity {
    Button startQuiz,createQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startQuiz=findViewById(R.id.startQuiz);
        createQuiz=findViewById(R.id.createQuiz);
        startQuiz.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), ListOfCategory.class)));
        createQuiz.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),CreateQuiz.class));
        });

    }
}