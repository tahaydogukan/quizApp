package com.tahayasindogukan.quizapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.tahayasindogukan.quizapp.datasource.WordDatabase
import com.tahayasindogukan.quizapp.datasource.WordRepository
import com.tahayasindogukan.quizapp.entity.SavedWords
import com.tahayasindogukan.quizapp.entity.Word
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SavedWordsViewModel(application: Application):AndroidViewModel(application) {

    val  readAllData:LiveData<List<SavedWords>>
    private val repository: WordRepository
    init {

        val wordDao= WordDatabase.getDatabase(application).wordDao()
        repository = WordRepository(wordDao)
        readAllData = repository.readAllData
    }


    fun addWord(word: SavedWords){
        viewModelScope.launch ( Dispatchers.IO ){
            repository.addWord(word)
        }
    }

    fun deleteWord(word: SavedWords){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteWord(word)
        }
    }
}