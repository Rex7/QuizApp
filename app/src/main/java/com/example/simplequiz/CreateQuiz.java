package com.example.simplequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.simplequiz.roomdb.Quiz;
import com.example.simplequiz.roomdb.QuizDao;
import com.example.simplequiz.roomdb.QuizImp;

public class CreateQuiz extends AppCompatActivity {
    Button createQuiz;
    EditText category,optionA,optionB,optionC,optionD,question,answer;
    Spinner categorySpinner;
    String[] options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quiz);
        question=findViewById(R.id.createQuestion);
        createQuiz=findViewById(R.id.createButton);
        optionA=findViewById(R.id.createOptionA);
        optionB=findViewById(R.id.createOptionB);
        optionC=findViewById(R.id.createOptionC);
        optionD=findViewById(R.id.createOptionD);
        options=getResources().getStringArray(R.array.category);
        categorySpinner=findViewById(R.id.answer);

        ArrayAdapter<CharSequence> arrayAdapter= ArrayAdapter.createFromResource(this,R.array.category, android.R.layout.simple_spinner_item);
        categorySpinner.setAdapter(arrayAdapter);
        category=findViewById(R.id.category);
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.v("SelectedValue",""+options[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        createQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Quiz quiz=new Quiz();
                QuizDao quizDao= QuizImp.getDatabase(getApplicationContext()).quizDao();
                quiz.setQuestion(question.getText().toString());
                quiz.setCategory(category.getText().toString());
               quiz.setOptionA(optionA.getText().toString());
               quiz.setOptionB(optionB.getText().toString());
               quiz.setOptionC(optionC.getText().toString());
               quiz.setOptionD(optionD.getText().toString());
                quiz.setAnswer(answer.getText().toString());
                quizDao.insert(quiz);


            }
        });
    }
}