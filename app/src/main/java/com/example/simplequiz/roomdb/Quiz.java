package com.example.simplequiz.roomdb;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.RoomWarnings;

@SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
@Entity
public class Quiz implements Parcelable {

    private String question;
    private String  optionA,optionB,optionC,optionD;
    private String answer;
    private Quiz(Parcel parcel){
        setQuestion(parcel.readString());
        setCategory(parcel.readString());
        setAnswer(parcel.readString());
        setOptionA(parcel.readString());
        setOptionB(parcel.readString());
        setOptionC(parcel.readString());
        setOptionD(parcel.readString());
    }

    public Quiz(){

    }
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }



    @PrimaryKey(autoGenerate = true)
    @Nullable
    public Integer id;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    private String category;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
   parcel.writeString(getQuestion());
   parcel.writeString(getAnswer());
   parcel.writeString(getCategory());
   parcel.writeString(getOptionA());
   parcel.writeString(getOptionB());
   parcel.writeString(getOptionC());
   parcel.writeString(getOptionD());

    }
    public  static  final  Parcelable.Creator<Quiz> CREATOR = new Creator<Quiz>() {
        @Override
        public Quiz createFromParcel(Parcel parcel) {
            return  new Quiz(parcel);
        }

        @Override
        public Quiz[] newArray(int i) {
            return new Quiz[i];
        }
    };
}
