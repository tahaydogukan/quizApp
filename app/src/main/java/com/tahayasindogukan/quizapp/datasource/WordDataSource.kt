package com.tahayasindogukan.quizapp.datasource

import com.tahayasindogukan.quizapp.entity.SavedWords
import com.tahayasindogukan.quizapp.room.WordDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WordDataSource (var wDao:WordDao){

//işlem burda yapılıyor
    suspend fun getWords():List<SavedWords> =
        withContext(Dispatchers.IO){
            return@withContext wDao.getAll()
        }


}