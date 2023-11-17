package com.tahayasindogukan.quizapp.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.tahayasindogukan.quizapp.entity.Quiz

class QuizListRepository(private val callback: (List<Quiz>) -> Unit) {
    private val firestore = FirebaseFirestore.getInstance()
    var quizList= ArrayList<Quiz>()


    fun getQuizData():ArrayList<Quiz>{
      firestore.collection("Quiz")
            .get()
            .addOnSuccessListener {documents->
                for (d in documents) {
                    Log.d("for", "${d}")
                    var quiz=d.toObject(Quiz::class.java)

                        quiz.quizId=d.id
                        quizList.add(quiz)

                }
                Log.e("repo", quizList.toString())
                callback(quizList)
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents: ", exception)
                callback(emptyList())
            }
        Log.e("repo",quizList.toString())
      return quizList
    }



}