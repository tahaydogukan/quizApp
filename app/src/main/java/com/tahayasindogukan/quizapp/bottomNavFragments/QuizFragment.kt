package com.tahayasindogukan.quizapp.bottomNavFragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.tahayasindogukan.quizapp.databinding.FragmentQuizBinding
import com.tahayasindogukan.quizapp.entity.QuestionWord
import com.tahayasindogukan.quizapp.entity.SavedWords
import com.tahayasindogukan.quizapp.viewmodel.AuthViewModel
import com.tahayasindogukan.quizapp.viewmodel.QuestionWordsViewModel
import com.tahayasindogukan.quizapp.viewmodel.SavedWordsViewModel
import kotlin.random.Random

class QuizFragment : Fragment() {
    private lateinit var binding: FragmentQuizBinding
    private lateinit var questionWordsViewModel: QuestionWordsViewModel
    private lateinit var savedWordViewModel: SavedWordsViewModel
    private val authViewModel: AuthViewModel by viewModels()

    var indeks:Int?=null
    //var questionListIndeks:Int=1
    var correctTranslation:String?=null
    var randomQuestionWord:QuestionWord?=null
    var questionWordsList:MutableList<QuestionWord> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel: QuestionWordsViewModel by viewModels()
        questionWordsViewModel = tempViewModel

        val tempViewModel2: SavedWordsViewModel by viewModels()
        savedWordViewModel = tempViewModel2


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentQuizBinding.inflate(inflater, container, false)

        questionWordsViewModel.getQuestion()

        questionWordsViewModel.question.observe(viewLifecycleOwner){data->
            uploadQuestions(data as MutableList)
            questionWordsList=data
        }
        Log.e("fragmentWordList",questionWordsList.toString())
        binding.saveWord.setOnClickListener {
            insertDataToDatabase()
        }

        authViewModel.getUserData()
        authViewModel.user.observe(viewLifecycleOwner){ data->
            binding.apply {
            quizQuestionsCount.text="${data.score}"
            }
        }


        /* binding.apply {

            easyButton.setOnClickListener{
                updtateQuestionList(1)
            }
            mediumButton.setOnClickListener{
                updtateQuestionList(2)
            }
            hardButton.setOnClickListener{
                updtateQuestionList(3)
            }

        binding.saveWord.setOnClickListener {
            insertDataToDatabase()
        }




        }*/
        return binding.root
    }


  private fun insertDataToDatabase() {

        val english_word = randomQuestionWord?.englishWord
        val turkish_word = correctTranslation

        val word = SavedWords(0, english_word!!, turkish_word!!)
        savedWordViewModel.findWord(turkish_word)
        savedWordViewModel.count.observe(viewLifecycleOwner) { data ->

            if (data == 0) {
                savedWordViewModel.addWord(word)
            } else {
                showToast("Bu kelime zaten kayıtlı.")
            }

        }
    }
    /*fun updateQuestionList(i: Int) {
        when(i) {
            1->{var wordList=wordViewModel.getQuestionsList(1)
                uploadQuestions(wordList)
            questionListIndeks=1}
            2->{var wordList1=wordViewModel.getQuestionsList(2)
                uploadQuestions(wordList1)
                questionListIndeks=2}
            3->{var wordList2=wordViewModel.getQuestionsList(3)
                uploadQuestions(wordList2)
                questionListIndeks=3}
        }
    }*/

    fun getQuestion(){
        questionWordsViewModel.getQuestion()
        var question = questionWordsViewModel.question

        //binding.textViewQuestion.text=question[1].englishWord.toString()

        Log.e("fragment",question.toString())

    }

    private fun uploadQuestions(questionWordsList: MutableList<QuestionWord>) {
        indeks = Random.nextInt(questionWordsList.size)
        randomQuestionWord = questionWordsList[indeks!!]
        correctTranslation = randomQuestionWord!!.turkishWord
        binding.textViewQuestion.text = randomQuestionWord!!.englishWord

        val buttonOptions = listOf(binding.option1Btn, binding.option2Btn, binding.option3Btn)
        buttonOptions.shuffled()  // Rasgele sıralama

        buttonOptions[0].text = randomQuestionWord!!.turkishWord  // Doğru cevap ilk butona
        buttonOptions[1].text = questionWordsList.random().turkishWord  // Rastgele yanlış cevap
        buttonOptions[2].text = questionWordsList.random().turkishWord  // Rastgele yanlış cevap

        buttonOptions.forEach { button ->
            button.setOnClickListener { checkAnswer(button, randomQuestionWord!!.turkishWord) }
        }
    }
    private fun checkAnswer(button: Button, correctTranslation:String) {
        val userAnswer = button.text.toString()
        if (userAnswer == correctTranslation) {
            showToast("Doğru! Tebrikler.")
            authViewModel.increaseScore(1)

        } else {
            showToast("Yanlış. Doğru cevap: $correctTranslation")
            authViewModel.decreaseScore(1)
        }
        questionWordsViewModel.getQuestion()
        //uploadQuestions(questionWordsList)
    }
     private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}


