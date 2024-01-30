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
import androidx.lifecycle.Observer
import com.tahayasindogukan.quizapp.databinding.FragmentQuizBinding
import com.tahayasindogukan.quizapp.entity.SavedWords
import com.tahayasindogukan.quizapp.entity.Word
import com.tahayasindogukan.quizapp.viewmodel.SavedWordsViewModel
import com.tahayasindogukan.quizapp.viewmodel.WordViewModel
import kotlin.random.Random
class QuizFragment : Fragment() {
    private lateinit var binding: FragmentQuizBinding
    private lateinit var wordViewModel:WordViewModel
    private lateinit var savedWordViewModel: SavedWordsViewModel

    var indeks:Int?=null
    var questionListIndeks:Int=1
    var correctTranslation:String?=null
    var randomWord:Word?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel:WordViewModel by viewModels()
        wordViewModel=tempViewModel

        val tempViewModel2:SavedWordsViewModel by viewModels()
        savedWordViewModel=tempViewModel2


    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= FragmentQuizBinding.inflate(inflater,container,false)

        updtateQuestionList(1)

        binding.apply {

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




        }
        return binding.root
    }



    private fun insertDataToDatabase() {

        val english_word = randomWord?.question_word
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

    fun updtateQuestionList(i: Int) {
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
    }

    private fun uploadQuestions(wordList:List<Word>){

        var randomIndex= Random.nextInt(wordList.size)
        indeks=randomIndex
        Log.e("ındeks numarası",indeks.toString())

        randomWord=wordList[randomIndex]

        correctTranslation = randomWord!!.answer_word

        binding.textViewQuestion.text= randomWord!!.question_word

        var correctButtonIndex=(0..2).random()
        when(correctButtonIndex){
            0->binding.option1Btn.text=correctTranslation
            1->binding.option2Btn.text=correctTranslation
            2->binding.option3Btn.text=correctTranslation
        }

        if (correctButtonIndex==0){
           // val (falseButton1,falseButton2)=List(2){ Random.nextInt(1,3)}
            binding.option2Btn.text= randomWord!!.wrong_opsion1
            binding.option3Btn.text= randomWord!!.wrong_opsion2
        }else if(correctButtonIndex==1){
           // val falseButton1=0
           // val falseButton2=2
            binding.option1Btn.text= randomWord!!.wrong_opsion1
            binding.option3Btn.text= randomWord!!.wrong_opsion2
        }else if(correctButtonIndex==2){
           // val (falseButton1,falseButton2)=List(2){ Random.nextInt(0,2)}
            binding.option1Btn.text= randomWord!!.wrong_opsion1
            binding.option2Btn.text= randomWord!!.wrong_opsion2
        }

        binding.option1Btn.setOnClickListener{checkAnswer(binding.option1Btn, correctTranslation!!)}
        binding.option2Btn.setOnClickListener{checkAnswer(binding.option2Btn, correctTranslation!!)}
        binding.option3Btn.setOnClickListener{checkAnswer(binding.option3Btn, correctTranslation!!)}
    }
    private fun checkAnswer(button: Button,correctTranslation:String) {
        val userAnswer = button.text.toString()
        if (userAnswer == correctTranslation) {
            showToast("Doğru! Tebrikler.")

        } else {
            showToast("Yanlış. Doğru cevap: $correctTranslation")

        }
        uploadQuestions(wordViewModel.getQuestionsList(questionListIndeks))
    }
    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }


    }

