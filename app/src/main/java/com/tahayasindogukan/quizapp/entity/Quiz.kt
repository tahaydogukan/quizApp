package com.tahayasindogukan.quizapp.entity

import java.io.Serializable

data class Quiz(
    var quizId:String="",
    val title:String="",
    val questions:Int=0,
    val difficulty:String="",
    val image:String=""):Serializable  {
}