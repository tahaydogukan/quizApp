package com.tahayasindogukan.quizapp.bottomNavFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.tahayasindogukan.quizapp.adapter.SavedWordsAdapter
import com.tahayasindogukan.quizapp.databinding.FragmentSavedWordsBinding
import com.tahayasindogukan.quizapp.entity.SavedWords
import com.tahayasindogukan.quizapp.viewmodel.WordViewModel


class SavedWordsFragment : Fragment() {
    private lateinit var binding: FragmentSavedWordsBinding
    private lateinit var wordViewModel: WordViewModel
    private val wList=listOf(
        SavedWords("apple","elma"),
        SavedWords("book","kitap")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel:WordViewModel by viewModels()
        wordViewModel=tempViewModel
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= FragmentSavedWordsBinding.inflate(inflater,container,false)
        binding.savedWordsRecyclerView.layoutManager=LinearLayoutManager(requireContext())

       val wordAdapter=SavedWordsAdapter(wList)
       binding.savedWordsRecyclerView.adapter=wordAdapter



        return binding.root
    }


    }



