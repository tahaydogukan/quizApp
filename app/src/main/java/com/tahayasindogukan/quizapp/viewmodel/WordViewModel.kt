package com.tahayasindogukan.quizapp.viewmodel


import androidx.lifecycle.ViewModel
import com.tahayasindogukan.quizapp.entity.Word


class WordViewModel():ViewModel() {






    //data sourceda işlem yapılıyor sonra repoda çalıştırılıyor
    //viewmodelden de repodaki o fonksiyon kullanılıyor
    //var wrepo=WordRepository()
    //@ınject ile repo gerekliliğini ortadan kaldırıyoruz






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

}