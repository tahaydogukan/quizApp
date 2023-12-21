package com.tahayasindogukan.quizapp.util

import android.view.View
import androidx.navigation.Navigation
//mevcut sınıflara ekstra olarak kendimiz fonksiyon üretebiliyoruz
fun Navigation.gecisyap(a:View,b:Int){
    Navigation.findNavController(a).navigate(b)
}