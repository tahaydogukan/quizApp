package com.tahayasindogukan.quizapp.entity

import java.io.Serializable

data class User(val email: String="",
                val password: String="",
                val score:Int=0):Serializable{

}


