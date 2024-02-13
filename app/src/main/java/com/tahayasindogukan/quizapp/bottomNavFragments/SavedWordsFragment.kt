package com.tahayasindogukan.quizapp.bottomNavFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.tahayasindogukan.quizapp.adapter.SavedWordsAdapter
import com.tahayasindogukan.quizapp.adapter.WordInterface
import com.tahayasindogukan.quizapp.databinding.FragmentSavedWordsBinding
import com.tahayasindogukan.quizapp.viewmodel.SavedWordsViewModel


class SavedWordsFragment : Fragment() {
    private lateinit var binding: FragmentSavedWordsBinding
    private lateinit var savedWordsViewModel: SavedWordsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel:SavedWordsViewModel by viewModels()
        savedWordsViewModel=tempViewModel
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= FragmentSavedWordsBinding.inflate(inflater,container,false)

      // val wordAdapter=SavedWordsAdapter(wList)
      // binding.savedWordsRecyclerView.adapter=wordAdapter

        binding.savedWordsRecyclerView.layoutManager=LinearLayoutManager(requireContext())

        savedWordsViewModel.readAllData.observe(viewLifecycleOwner, Observer {user->
            val recyclerView=binding.savedWordsRecyclerView
            val adapter = SavedWordsAdapter(user,
                object :WordInterface{
                override fun delete(index: Int) {
                val a=user[index]
                savedWordsViewModel.deleteWord(a)
                }
            })
            recyclerView.adapter=adapter
            adapter.setData(user)
        })



        return binding.root
    }


    }



