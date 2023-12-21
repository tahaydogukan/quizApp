package com.tahayasindogukan.quizapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tahayasindogukan.quizapp.entity.SavedWords

@Database(entities = [SavedWords::class], version = 1)
abstract class WordDatabaseRoom:RoomDatabase(){
    abstract fun getWordsDao():WordDao
}