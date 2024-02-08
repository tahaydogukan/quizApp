package com.tahayasindogukan.quizapp.datasource


import com.tahayasindogukan.quizapp.entity.ApiResponse
import retrofit2.http.GET
//http://localhost:8080
///boruto/heroes
interface QuestionWordsDao {

    @GET("question")
    suspend fun getQuestionWords() : ApiResponse

    @GET("question2")
    suspend fun getQuestionWordsMedium() : ApiResponse

    @GET("question3")
    suspend fun getQuestionWordsHard() : ApiResponse



}