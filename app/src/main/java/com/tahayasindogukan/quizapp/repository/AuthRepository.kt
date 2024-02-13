package com.tahayasindogukan.quizapp.repository

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore


class AuthRepository {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun signUpRepository(
        email: String,
        password: String,
        name:String,
        surname:String,
        correctQuestionCount:Int,
        wrongQuestionCount:Int,
        onComplete: (Boolean, String?) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Kayıt başarılı
                    val user = task.result?.user
                    val uid = user?.uid
                    // Firestore'a veri ekleme
                    val db = FirebaseFirestore.getInstance()
                    val userRef = db.collection("users").document(uid!!)
                    val userMap = mutableMapOf<String, Any>()
                    userMap["name"] = name
                    userMap["surname"] = surname
                    userMap["email"] = email
                    userMap["score"] = 0
                    userMap["correctQuestionCount"] = correctQuestionCount
                    userMap["wrongQuestionCount"] = wrongQuestionCount

                    onComplete(true, user?.uid)

                    userRef.set(userMap)
                        .addOnSuccessListener {
                            // Veri ekleme başarılı
                            Log.e("Auth Repo","Kayıt Başarılı")
                        }.addOnFailureListener{
                            // Veri ekleme başarısız
                            Log.e("Auth Repo","Kayıt Başarısız")
                        }
                } else {
                    onComplete(false, task.exception?.message)
                }
            }
    }



    fun signInRepository(email: String, password: String, onComplete: (Boolean, String?) -> Unit){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onComplete(true, null)

                } else {
                    onComplete(false, task.exception?.message)
                }
            }
    }

    fun signOutRepository(onComplete: (Boolean) -> Unit) {
        auth.signOut()
        onComplete(true)
    }

    fun getCurrentUserRepository(): FirebaseUser? {
        return auth.currentUser
    }


    fun isUserLoggedInRepository(): Boolean {
        return auth.currentUser != null
    }

    
}




