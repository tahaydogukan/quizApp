package com.tahayasindogukan.quizapp.bottomNavFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.tahayasindogukan.quizapp.R
import com.tahayasindogukan.quizapp.databinding.FragmentQuizBinding
import com.tahayasindogukan.quizapp.databinding.FragmentSettingsBinding
import com.tahayasindogukan.quizapp.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint


class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding
    private val authViewModel: AuthViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentSettingsBinding.inflate(inflater, container, false)

        authViewModel.getUserData()
        authViewModel.user.observe(viewLifecycleOwner){ data->
            binding.apply {
                SettingsName.text="${data.name} ${data.surname}"
                SettingsScore.text=" Puan : ${data.score}"
                SettingsCountTrue.text="  Doğru Sayısı : ${data.correctQuestionCount}"
                SettingsCountWrong.text="  Yanlış Sayısı : ${data.wrongQuestionCount}"
            }
        }


        return binding.root
    }

}