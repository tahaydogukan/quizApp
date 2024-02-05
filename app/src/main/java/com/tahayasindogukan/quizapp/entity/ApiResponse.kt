package com.tahayasindogukan.quizapp.entity

import java.io.Serializable

data class ApiResponse(
                            val questionWordList:MutableList<QuestionWord>
                            ):Serializable {
}