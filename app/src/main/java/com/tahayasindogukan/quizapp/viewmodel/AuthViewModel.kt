package com.tahayasindogukan.quizapp.viewmodel


import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.firestore
import com.tahayasindogukan.quizapp.R
import com.tahayasindogukan.quizapp.entity.User
import com.tahayasindogukan.quizapp.repository.AuthRepository

class AuthViewModel():ViewModel() {

    val auth=AuthRepository()

    fun signUpViewModel(email:String,password: String, onComplete: (Boolean, String?) -> Unit){
        auth.signUpRepository(email,password){
                success, message ->
            if (success) {
                onComplete(success, message)

            }
                // Kayıt başarılı, ek işlemleri yapabilirsiniz.
                val user = auth.getCurrentUserRepository()
                // User nesnesini kullanabilir veya UI'yi güncelleyebilirsiniz.
            /*else {
               Kayıt başarısız, kullanıcıya hata mesajı gösterilebilir.
            }    */
        }
    }

    fun signInViewModel(email:String,password: String, onComplete: (Boolean, String?) -> Unit){
        auth.signInRepository(email,password){ success, message ->
                onComplete(success, message)
        }
    }

    fun currentUserViewModel():FirebaseUser?{
        return auth.getCurrentUserRepository()
    }


}