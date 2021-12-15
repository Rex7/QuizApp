package com.example.simplequiz.roomdb;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RoomWarnings;

@Dao
public interface QuizDao {
    @Insert
    public void insert(Quiz...quiz);

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("select DISTINCT category from quiz order by id")
    public List<Quiz> getCategory();
    @Query("select * from quiz where category = :category")
    public List<Quiz> getQuiz(String category);
}
