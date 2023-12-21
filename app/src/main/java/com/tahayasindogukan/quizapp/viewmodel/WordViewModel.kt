package com.tahayasindogukan.quizapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tahayasindogukan.quizapp.entity.SavedWords
import com.tahayasindogukan.quizapp.entity.Word
import com.tahayasindogukan.quizapp.repository.WordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordViewModel @Inject constructor(var wordRepo:WordRepository): ViewModel() {
    var indeksList:MutableList<Int> = mutableListOf()
    var wordList=MutableLiveData<List<SavedWords>>()

    //data sourceda işlem yapılıyor sonra repoda çalıştırılıyor
    //viewmodelden de repodaki o fonksiyon kullanılıyor
    //var wrepo=WordRepository()
    //@ınject ile repo gerekliliğini ortadan kaldırıyoruz



    init {
        uploadWords()
    }


    fun getQuestionsList(i:Int):List<Word>{
        when(i){
            1->{
                return listOf<Word>(
                    Word("Apple",
                        "Elma",
                        "Armut",
                        "Kiraz"),

                    Word("Home",
                        "Ev",
                        "Otel",
                        "Araba"),

                    Word("Mouth",
                        "Ağız",
                        "Yanak",
                        "El"),

                    Word("Door",
                        "Kapı",
                        "Pencere",
                        "Mutfak"),

                    Word("Kitchen",
                        "Mutfak",
                        "Salon",
                        "Banyo"))
            }
            2->{
               return listOf<Word>(

                    Word("Brave",
                        "Cesur",
                        "Huysuz",
                        "Mutsuz"),

                    Word("Smile",
                        "Gülümseme",
                        "Ağlama",
                        "Bakmak"),

                    Word("Journey",
                        "Yolculuk",
                        "Uyku",
                        "Kitap"),

                    Word("Song",
                        "Şarkı",
                        "Bulut",
                        "Göz"),

                    Word("Cloud",
                        "Bulut",
                        "Güneş",
                        "Ay"))

            }
            3->{
              return  listOf<Word>(

                    Word("Pernicious",
                        "Zararlı,Kötü Etkili",
                        "Kullanışlı",
                        "Bencil"),

                    Word("Voracious",
                        "Aşırı Doymaz",
                        "Kısa Ömürlü",
                        "Gürültü"),

                    Word("Cacophony",
                        "Gürültü",
                        "Çaba,Gayret",
                        "Sevimsiz"),

                    Word("Alleviate",
                        "Hafifletmek",
                        "Abartmak",
                        "Bayılmak"),

                    Word("Melancholy",
                        "Hüzün",
                        "Sevinç",
                        "Merak"))
            }
        }
        return emptyList()
    }
    fun uploadWords(){
        //Main arayüz işlemlelerinde IO veritabanı kısmında kullanılıyor
        CoroutineScope(Dispatchers.Main).launch {
            wordList.value=wordRepo.getWords()
            Log.e("ViewModel",wordList.toString())
        }
    }
}