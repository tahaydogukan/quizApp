package com.tahayasindogukan.quizapp.dependincyInjection

import android.content.Context
import androidx.room.Room
import com.tahayasindogukan.quizapp.datasource.WordDataSource
import com.tahayasindogukan.quizapp.repository.WordRepository
import com.tahayasindogukan.quizapp.room.WordDao
import com.tahayasindogukan.quizapp.room.WordDatabaseRoom
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideWordDataSource(wDao: WordDao):WordDataSource{
        return WordDataSource(wDao)
    }

    @Provides
    @Singleton
    fun provideWordRepository(wds:WordDataSource):WordRepository{
        return WordRepository(wds)
    }
    @Provides
    @Singleton
    fun provideWordDao(@ApplicationContext context:Context):WordDao{
        val db = Room.databaseBuilder(context
            , WordDatabaseRoom::class.java
            , "savedWords.db")
            .createFromAsset("savedWords.db")
            .build()
        return db.getWordsDao()
    }
}