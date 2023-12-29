package com.tahayasindogukan.quizapp.datasource

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tahayasindogukan.quizapp.entity.SavedWords
@Dao
interface WordDao {

    @Query("SELECT * FROM savedWords ORDER BY word_id ASC")
    fun readAllData():LiveData<List<SavedWords>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addWord(savedWords:SavedWords)

    @Delete
    suspend fun deleteWord(savedWords: SavedWords)

}