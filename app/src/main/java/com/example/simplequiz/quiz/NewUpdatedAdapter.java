package com.example.simplequiz.quiz;



import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.simplequiz.R;
import com.example.simplequiz.roomdb.Quiz;
import com.example.simplequiz.roomdb.QuizDao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NewUpdatedAdapter extends RecyclerView.Adapter<NewUpdatedAdapter.Viewholders>  {
    QuizDao databaseHelper;
    ArrayList<Quiz> quizArrayList=new ArrayList<>();
    RecyclerView.RecycledViewPool recycledViewPool;
    String category;
    Context ctx;
    RecyclerView parent;
    public  NewUpdatedAdapter(Context ctx, QuizDao databaseHelper, ArrayList<Quiz> quizArrayList, String category, RecyclerView recyclerView){
        this.databaseHelper=databaseHelper;
        this.ctx=ctx;
        this.quizArrayList=quizArrayList;
        recycledViewPool=new RecyclerView.RecycledViewPool();
        this.category=category;
        this.parent=recyclerView;
    }

    @NonNull
    @Override
    public Viewholders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_quiz_design, parent, false);
        return  new NewUpdatedAdapter.Viewholders(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholders holder, int position) {
        holder.question_title_quiz.setText(""+quizArrayList.get(0).getQuestion());
        Log.v("Question",""+quizArrayList.get(0).getQuestion());
        OptionChildAdapter childAdapter=new OptionChildAdapter(ctx.getApplicationContext(),quizArrayList,category,parent);
        holder.childRecycler.setLayoutManager(new LinearLayoutManager(ctx.getApplicationContext(),LinearLayoutManager.VERTICAL,false));

        holder.childRecycler.setItemAnimator(new DefaultItemAnimator());
        holder.childRecycler.setAdapter(childAdapter);

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class Viewholders extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView question_title_quiz;
        RecyclerView childRecycler;

        public Viewholders(@NonNull View itemView) {
            super(itemView);
            childRecycler=itemView.findViewById(R.id.option);
            question_title_quiz=itemView.findViewById(R.id.questTitleCard);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.v("UpdatedVal","clicked"+getAdapterPosition());




        }
    }
}
