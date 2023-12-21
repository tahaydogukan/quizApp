package com.tahayasindogukan.quizapp.bottomNavFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.tahayasindogukan.quizapp.adapter.SavedWordsAdapter
import com.tahayasindogukan.quizapp.databinding.FragmentSavedWordsBinding
import com.tahayasindogukan.quizapp.viewmodel.WordViewModel

class SavedWordsFragment : Fragment() {
    private lateinit var binding: FragmentSavedWordsBinding
    private lateinit var adapter: SavedWordsAdapter
    private lateinit var wordViewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel:WordViewModel by viewModels()
        wordViewModel=tempViewModel
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= FragmentSavedWordsBinding.inflate(inflater,container,false)

       wordViewModel.wordList.observe(viewLifecycleOwner) {
            val wAdapter=SavedWordsAdapter(it)
            adapter= SavedWordsAdapter(it)
            binding.savedWordsRecyclerView.adapter=adapter

        }/*
        binding.savedWordsRecyclerView.layoutManager=LinearLayoutManager(requireContext())
        val list=ArrayList<SavedWords>()
        val kisiList=SavedWords(1,"a","b")
        val kisiList2=SavedWords(2,"c","d")
        list.add(kisiList)
        list.add(kisiList2)
        adapter=SavedWordsAdapter(list)
        binding.savedWordsRecyclerView.adapter=adapter
*/

        //wordViewModel.sonuc.observe(this){
        //it nesnesinde gelen veriyi bir şeye atıyoruz altta
        //her veri geldiğinde alttaki fonksiyon çalışıyor
          //  binding.savedWordsRecyclerView=it
       // }


        return binding.root
    }


    }



