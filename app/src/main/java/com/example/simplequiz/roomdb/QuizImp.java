package com.example.simplequiz.roomdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Quiz.class},version = 2,exportSchema = false)
public  abstract class QuizImp extends RoomDatabase {
    private static volatile QuizImp quizImp;
    public abstract QuizDao quizDao();
    public static  QuizImp getDatabase(final Context ct){
        if(quizImp==null){
            synchronized (QuizImp.class){
                if(quizImp==null){
                    quizImp= Room.databaseBuilder(ct.getApplicationContext(),QuizImp.class,"qui_db")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return quizImp;
    }

}
