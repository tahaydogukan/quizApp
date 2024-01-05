package com.tahayasindogukan.quizapp.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tahayasindogukan.quizapp.entity.SavedWords

@Database(entities = [SavedWords::class], version = 1, exportSchema = false)
abstract class WordDatabase: RoomDatabase() {
    abstract fun wordDao(): WordDao

    companion object{
        @Volatile
        private var INSTANCE :WordDatabase? = null

            fun  getDatabase(context: Context):WordDatabase{
                val tempInstance = INSTANCE
                if(tempInstance!= null){
                   return tempInstance
                }
                synchronized(this){
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        WordDatabase::class.java,
                        "saved_words"
                    ).build()
                    INSTANCE = instance
                    return instance
                }
            }


    }
}