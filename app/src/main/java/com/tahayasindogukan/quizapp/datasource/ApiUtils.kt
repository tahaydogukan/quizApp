package com.tahayasindogukan.quizapp.datasource

class ApiUtils {
    companion object{
        val BASE_URL = "http://10.0.2.2:8081/"

        fun getQuestionWordsDao() : QuestionWordsDao{
            return RetrofitClient.getClient(BASE_URL).create(QuestionWordsDao::class.java)
        }
    }
}