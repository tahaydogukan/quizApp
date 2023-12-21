package com.tahayasindogukan.quizapp.repository

import com.tahayasindogukan.quizapp.datasource.WordDataSource
import com.tahayasindogukan.quizapp.entity.SavedWords

class WordRepository(var wds:WordDataSource) {
    //işlemlerin çalışması burda yönetiliyor
    //bu sadece fonksiyonu çalıştırıyor değeri alıp bir önceki katmana aktarıyor
    //viewmodel->repo->data source
    //repo değeri viewmodele aktarıyor

    suspend fun getWords():List<SavedWords> = wds.getWords()


    //    suspend fun getWords(a:Int,b:Int):Int=wds.getWords(a,b)
    //   yukarıdakiyle aynı şeyi yapıyor
}