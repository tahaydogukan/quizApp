package com.tahayasindogukan.quizapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.tahayasindogukan.quizapp.entity.SavedWords

@Dao
interface WordDao {
    @Query("SELECT * FROM words")
    suspend fun getAll(): List<SavedWords>

}