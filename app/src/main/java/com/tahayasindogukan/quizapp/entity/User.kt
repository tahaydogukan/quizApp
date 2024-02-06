package com.tahayasindogukan.quizapp.entity

import java.io.Serializable

data class User(val name: String="",
                val surname: String="",
                val email:String="",
                val score:Long=0,
                val correctQuestionCount:Long=0,
                val wrongQuestionCount:Long=0):Serializable{

}


