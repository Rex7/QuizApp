package com.example.simplequiz.category;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.simplequiz.R;
import com.example.simplequiz.quiz.QuizUpdated;
import com.example.simplequiz.roomdb.Quiz;
import com.example.simplequiz.roomdb.QuizDao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryRecyclerAdapter.Viewholders>  {
    QuizDao databaseHelper;
    Context ctx;
    public  CategoryRecyclerAdapter(Context ctx,QuizDao databaseHelper){
        this.databaseHelper=databaseHelper;
        this.ctx=ctx;
    }

    @NonNull
    @Override
    public Viewholders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_category_list, parent, false);
        return  new CategoryRecyclerAdapter.Viewholders(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholders holder, int position) {
        Log.v("UpdatedValue",""+databaseHelper.getCategory().get(position).getCategory());
        holder.title.setText(databaseHelper.getCategory().get(position).getCategory());
    }

    @Override
    public int getItemCount() {
        return databaseHelper.getCategory().size();
    }

    class Viewholders extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        public Viewholders(@NonNull View itemView) {
            super(itemView);
          title=  itemView.findViewById(R.id.QuizCategoryTitle);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.v("UpdatedVal","clicked"+getAdapterPosition());
            String category=databaseHelper.getCategory().get(getAdapterPosition()).getCategory().toString();
            ArrayList<Quiz> quizList= (ArrayList<Quiz>) databaseHelper.getQuiz(category);
            Intent intent=new Intent(ctx, QuizUpdated.class);
            Log.v("SizeValue","size"+quizList.size());
            intent.putParcelableArrayListExtra("listOfCategory", quizList);
            intent.putExtra("category",category);
            ctx.startActivity(intent);



        }
    }
}
