package com.tahayasindogukan.quizapp.datasource

import androidx.lifecycle.LiveData
import com.tahayasindogukan.quizapp.entity.SavedWords

class WordRepository(private val wordDao:WordDao) {

    val readAllData:LiveData<List<SavedWords>> = wordDao.readAllData()

    suspend fun addWord(word:SavedWords){
        wordDao.addWord(word)
    }

    suspend fun deleteWord(savedWords: SavedWords){
        wordDao.deleteWord(savedWords)
    }

    suspend fun findWord(word: String):Int {
        return wordDao.findWord(word)
    }
}