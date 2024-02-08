package com.tahayasindogukan.quizapp.repository

import com.tahayasindogukan.quizapp.datasource.ApiUtils
import com.tahayasindogukan.quizapp.datasource.QuestionWordsDao
import com.tahayasindogukan.quizapp.entity.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuestionWordsRepository {

    private val qwDao:QuestionWordsDao

    init {
        qwDao=ApiUtils.getQuestionWordsDao()
    }

    suspend fun uploadQuestionWords() : ApiResponse =
        withContext(Dispatchers.IO){
            return@withContext qwDao.getQuestionWords()

        }

    suspend fun uploadQuestionWordsMedium() : ApiResponse =
        withContext(Dispatchers.IO){
            return@withContext qwDao.getQuestionWordsMedium()

        }

    suspend fun uploadQuestionWordsHard() : ApiResponse =
        withContext(Dispatchers.IO){
            return@withContext qwDao.getQuestionWordsHard()

        }



}