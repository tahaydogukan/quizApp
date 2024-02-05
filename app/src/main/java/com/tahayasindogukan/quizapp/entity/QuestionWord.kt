package com.tahayasindogukan.quizapp.entity

import java.io.Serializable

data class QuestionWord(
                  val idOfWord: Int,
                  val turkishWord: String,
                  val englishWord: String,
                  val scoreOfWord: Int

):Serializable {
}