package com.example.simplequiz;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.simplequiz.roomdb.Quiz;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class QuestionAdapter  extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {

    ArrayList<Quiz> quizzes;
    ArrayList<String> values=new ArrayList<>();
    HashMap<Integer,String> quizAns=new HashMap<>();

    public  QuestionAdapter(ArrayList<Quiz> quizzes){
        this.quizzes=quizzes;
        Log.v("updatedValue","size"+quizzes.size());
    }




    @NonNull
    @Override
    public QuestionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_quiz, parent, false);
        return  new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionAdapter.ViewHolder holder, int position) {
        for (int i=0;i<=getItemCount();i++){
            holder.question.setText(quizzes.get(position).getQuestion());
            holder.radioButtonA.setText("" + quizzes.get(position).getOptionA());
            holder.radioButtonB.setText("" + quizzes.get(position).getOptionB());
            holder.radioButtonC.setText("" + quizzes.get(position).getOptionC());
            holder.radioButtonD.setText("" + quizzes.get(position).getOptionD());
        }

    }
    public HashMap<Integer,String> getAllSelectedValue(){
        return  quizAns;
    }
    public  void clearArray(ArrayList<Quiz> arrayList){
        quizzes.clear();
        quizzes.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return quizzes.size();
    }
    class  ViewHolder extends RecyclerView.ViewHolder{
        TextView question;
        RadioButton radioButtonA,radioButtonB,radioButtonC,radioButtonD,sele;
        RadioGroup radioGroup;;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            question= itemView.findViewById(R.id.question);
            radioGroup=(RadioGroup)itemView.findViewById(R.id.radioGroup);
            radioButtonA=itemView.findViewById(R.id.optionA);
            radioButtonB=itemView.findViewById(R.id.optionB);
            radioButtonC=itemView.findViewById(R.id.optionC);
            radioButtonD=itemView.findViewById(R.id.optionD);
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    RadioButton val=itemView.findViewById(i);
                    Log.v("ItemCount",""+val.toString());
                    int selectedId = radioGroup.getCheckedRadioButtonId();
                    switch (selectedId){
                        case R.id.optionA :
                            quizAns.put(getAdapterPosition(),"a");
                            break;
                        case R.id.optionB:
                            quizAns.put(getAdapterPosition(),"b");
                            break;
                        case R.id.optionC :
                            quizAns.put(getAdapterPosition(),"c");
                            break;
                        case R.id.optionD:
                            quizAns.put(getAdapterPosition(),"d");
                            break;


                    }

                    Log.v("HashMap",""+quizAns.get(getAdapterPosition()));
                }
            });






        }
    }
}
