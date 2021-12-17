package com.example.simplequiz.quiz;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.simplequiz.R;
import com.example.simplequiz.Results;
import com.example.simplequiz.roomdb.Quiz;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OptionChildAdapter  extends RecyclerView.Adapter<OptionChildAdapter.ViewHolder> {
   ArrayList<Quiz> quizArrayList;
   HashMap<Integer,String> results=new HashMap<>();
   Context ctx;
   String category;
   int newPosition=0;
   RecyclerView parentRecycler;
    public OptionChildAdapter(Context ctx, ArrayList<Quiz> quizArrayList, String category, RecyclerView parent){
        this.quizArrayList=quizArrayList;
        this.ctx=ctx;
        this.category=category;
        this.parentRecycler=parent;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_category_list, parent, false);
        return  new OptionChildAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        onButtonClick(newPosition);
      if(newPosition!=quizArrayList.size()) {
          if (position == 0) {

              holder.option.setText(quizArrayList.get(newPosition).getOptionA());
          } else if (position == 1) {

              holder.option.setText(quizArrayList.get(newPosition).getOptionB());
          } else if (position == 2) {
              holder.option.setText(quizArrayList.get(newPosition).getOptionC());
          } else if (position == 3) {
              holder.option.setText( quizArrayList.get(newPosition).getOptionD());
          }
      }
    }
    private void onButtonClick(int position) {
        if(newPosition!=0 && newPosition!=quizArrayList.size()) {
            NewUpdatedAdapter.Viewholders v = (NewUpdatedAdapter.Viewholders) parentRecycler.findViewHolderForAdapterPosition(0);
            v.question_title_quiz.setText(quizArrayList.get(position).getQuestion());
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView option;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            option=itemView.findViewById(R.id.QuizCategoryTitle);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.v("ClickedAdapter",""+getAdapterPosition());
            switch(getAdapterPosition()){
                case 0:
                    results.put(getAdapterPosition(),"a");
                    break;
                case 1:
                    results.put(getAdapterPosition(),"b");
                    break;
                case 2:
                    results.put(getAdapterPosition(),"c");
                    break;
                case 3:
                    results.put(getAdapterPosition(),"d");
                    break;

            }

            ChangeOptions();
        }
    }
    public void ChangeOptions(){
        if(newPosition==(quizArrayList.size()-1)){
            newPosition=0;
          Intent intent=new Intent(ctx.getApplicationContext(), Results.class);
          intent.putExtra("answerList",results);
          intent.putExtra("category",category);
          intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
          ctx.startActivity(intent);
        }
        else {
            newPosition++;
        }
        notifyDataSetChanged();
    }
}
