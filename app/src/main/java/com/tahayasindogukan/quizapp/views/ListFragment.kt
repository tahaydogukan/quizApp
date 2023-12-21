package com.tahayasindogukan.quizapp.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.tahayasindogukan.quizapp.databinding.FragmentListBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.tahayasindogukan.quizapp.adapter.QuizListAdapter
import com.tahayasindogukan.quizapp.entity.Quiz
import com.tahayasindogukan.quizapp.viewmodel.QuizListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private lateinit var adapter:QuizListAdapter
    private lateinit var quizListViewModel: QuizListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel:QuizListViewModel by viewModels()
        quizListViewModel=tempViewModel
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding= FragmentListBinding.inflate(inflater,container,false)

        binding.listQuizRecyclerView.layoutManager=LinearLayoutManager(requireContext())
        quizListViewModel.getData()
        quizListViewModel.quizListesi.observe(viewLifecycleOwner){data->

             adapter=QuizListAdapter(data)
             binding.listQuizRecyclerView.adapter=adapter
            Log.e("fragment", data.toString())

        }
        return binding.root
    }
}