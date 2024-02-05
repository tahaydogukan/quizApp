package com.tahayasindogukan.quizapp.viewmodel


import androidx.lifecycle.ViewModel


class WordViewModel():ViewModel() {






    //data sourceda işlem yapılıyor sonra repoda çalıştırılıyor
    //viewmodelden de repodaki o fonksiyon kullanılıyor
    //var wrepo=WordRepository()
    //@ınject ile repo gerekliliğini ortadan kaldırıyoruz






   /* fun getQuestionsList(i:Int):List<QuestionWords>{
        when(i){
            1->{
                return listOf<QuestionWords>(
                    QuestionWords("Apple",
                        "Elma",
                        "Armut",
                        "Kiraz"),

                    QuestionWords("Home",
                        "Ev",
                        "Otel",
                        "Araba"),

                    QuestionWords("Mouth",
                        "Ağız",
                        "Yanak",
                        "El"),

                    QuestionWords("Door",
                        "Kapı",
                        "Pencere",
                        "Mutfak"),

                    QuestionWords("Kitchen",
                        "Mutfak",
                        "Salon",
                        "Banyo"))
            }
            2->{
               return listOf<QuestionWords>(

                    QuestionWords("Brave",
                        "Cesur",
                        "Huysuz",
                        "Mutsuz"),

                    QuestionWords("Smile",
                        "Gülümseme",
                        "Ağlama",
                        "Bakmak"),

                    QuestionWords("Journey",
                        "Yolculuk",
                        "Uyku",
                        "Kitap"),

                    QuestionWords("Song",
                        "Şarkı",
                        "Bulut",
                        "Göz"),

                    QuestionWords("Cloud",
                        "Bulut",
                        "Güneş",
                        "Ay"))

            }
            3->{
              return  listOf<QuestionWords>(

                    QuestionWords("Pernicious",
                        "Zararlı,Kötü Etkili",
                        "Kullanışlı",
                        "Bencil"),

                    QuestionWords("Voracious",
                        "Aşırı Doymaz",
                        "Kısa Ömürlü",
                        "Gürültü"),

                    QuestionWords("Cacophony",
                        "Gürültü",
                        "Çaba,Gayret",
                        "Sevimsiz"),

                    QuestionWords("Alleviate",
                        "Hafifletmek",
                        "Abartmak",
                        "Bayılmak"),

                    QuestionWords("Melancholy",
                        "Hüzün",
                        "Sevinç",
                        "Merak"))
            }
        }
        return emptyList()
    }*/

}