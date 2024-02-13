package com.tahayasindogukan.quizapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.tahayasindogukan.quizapp.entity.User
import com.tahayasindogukan.quizapp.repository.AuthRepository

class AuthViewModel : ViewModel() {

    private val auth = AuthRepository()
    private val db = FirebaseFirestore.getInstance()

    //val usersRef = db.collection("users")
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user
    val scoree = MutableLiveData<Long>()
    private val firebaseUser = currentUserViewModel()
    private val _score = MutableLiveData<List<DocumentSnapshot>>()


    fun getUserData() {
        if (firebaseUser != null) {
            // Firestore'dan kullanıcı bilgilerini oku
            val db = FirebaseFirestore.getInstance()
            val userRef = db.collection("users").document(firebaseUser.uid)
            userRef.get()
                .addOnSuccessListener { document ->
                    val user = User(
                        document["name"] as String,
                        document["surname"] as String,
                        document["email"] as String,
                        document["score"] as Long,
                        document["correctQuestionCount"] as Long,
                        document["wrongQuestionCount"] as Long
                    )
                    _user.value = user
                }
        }
    }

    fun getAllUsersOrderByScore() {
        val db = FirebaseFirestore.getInstance()
        val userRef = db.collection("users")

        val query = userRef.orderBy("score").limit(10)

        query.addSnapshotListener { querySnapshot, error ->
            if (error != null) {
                // Hata işleme
            } else {
                val documents = mutableListOf<DocumentSnapshot>()
                for (document in querySnapshot?.documents!!) {
                    documents.add(document)
                }
                _score.value = documents
            }
        }
    }

    fun getUsers(): LiveData<List<DocumentSnapshot>> {
        getAllUsersOrderByScore()
        return _score
    }

    fun signUpViewModel(
        email: String,
        password: String,
        name: String,
        surname: String,
        correctQuestionCount: Int,
        wrongQuestionCount: Int,
        onComplete: (Boolean, String?) -> Unit
    ) {
        auth.signUpRepository(
            email,
            password,
            name,
            surname,
            correctQuestionCount,
            wrongQuestionCount
        ) { success, message ->
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

    fun signInViewModel(email: String, password: String, onComplete: (Boolean, String?) -> Unit) {
        auth.signInRepository(email, password) { success, message ->
            onComplete(success, message)
        }
    }

    fun updateScore(score: Long) {
        // Firestore'da kullanıcı puanını güncelle
        val db = FirebaseFirestore.getInstance()
        val userRef = db.collection("users").document(currentUserViewModel()?.uid!!)
        userRef.update("score", FieldValue.increment(score))
    }

    fun decreaseScore(score: Long) {
        // Firestore'da kullanıcı puanını güncelle
        val db = FirebaseFirestore.getInstance()
        val userRef = db.collection("users").document(currentUserViewModel()?.uid!!)

        userRef.update("score", FieldValue.increment(-score))

    }

    fun updateWrongQuestionCount() {
        // Firestore'da yanlış sayısını güncelle
        val db = FirebaseFirestore.getInstance()
        val userRef = db.collection("users").document(currentUserViewModel()?.uid!!)

        userRef.update("wrongQuestionCount", FieldValue.increment(1))

    }

    fun updateCorrectQuestionCount() {
        // Firestore'da doğru sayısını güncelle
        val db = FirebaseFirestore.getInstance()
        val userRef = db.collection("users").document(currentUserViewModel()?.uid!!)

        userRef.update("correctQuestionCount", FieldValue.increment(1))

    }

    fun currentUserViewModel(): FirebaseUser? {
        return auth.getCurrentUserRepository()
    }

    fun signOutViewModel(onComplete: (Boolean) -> Unit) {
        auth.signOutRepository(onComplete)
    }

}