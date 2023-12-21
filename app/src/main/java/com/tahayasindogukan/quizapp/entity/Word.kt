package com.tahayasindogukan.quizapp.entity

import java.io.Serializable

data class Word(var question_word:String,
                var answer_word:String,
                var wrong_opsion1:String,
                var wrong_opsion2:String):Serializable {
}