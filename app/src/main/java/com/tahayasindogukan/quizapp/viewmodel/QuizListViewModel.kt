package com.tahayasindogukan.quizapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tahayasindogukan.quizapp.entity.Quiz
import com.tahayasindogukan.quizapp.repository.QuizListRepository

class QuizListViewModel():ViewModel(){

    var quizListesi=MutableLiveData<List<Quiz>>()

    val repo=QuizListRepository{ quizList ->
        quizListesi.postValue(quizList)
        Log.e("viewmodle repo", quizList.toString())
    }
    fun getData() {
        quizListesi.postValue(repo.getQuizData())
        Log.e("getdata function",quizListesi.toString())
    }
}

