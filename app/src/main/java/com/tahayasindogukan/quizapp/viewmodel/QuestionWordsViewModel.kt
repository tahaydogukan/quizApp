package com.tahayasindogukan.quizapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tahayasindogukan.quizapp.entity.QuestionWord
import com.tahayasindogukan.quizapp.repository.QuestionWordsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuestionWordsViewModel:ViewModel(){

    var question=MutableLiveData<List<QuestionWord>>()
    val qRepo=QuestionWordsRepository()

    init {
        //getQuestion()
    }
     fun getQuestion(){
        viewModelScope.launch(Dispatchers.Main){
            question.value = qRepo.uploadQuestionWords().questionWordList
            Log.e("viewmodel",question.toString())
        }
    }

    fun getQuestionMedium(){
        viewModelScope.launch(Dispatchers.Main){
            question.value = qRepo.uploadQuestionWordsMedium().questionWordList
            Log.e("viewmodel",question.toString())
        }
    }

    fun getQuestionHard(){
        viewModelScope.launch(Dispatchers.Main){
            question.value = qRepo.uploadQuestionWordsHard().questionWordList
            Log.e("viewmodel",question.toString())
        }
    }

}