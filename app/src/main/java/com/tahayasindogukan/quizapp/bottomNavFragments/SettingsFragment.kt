package com.tahayasindogukan.quizapp.bottomNavFragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.tahayasindogukan.quizapp.activities.MainActivity
import com.tahayasindogukan.quizapp.adapter.SettingsAdapter
import com.tahayasindogukan.quizapp.databinding.FragmentSettingsBinding
import com.tahayasindogukan.quizapp.viewmodel.AuthViewModel


class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding
    private val authViewModel: AuthViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSettingsBinding.inflate(inflater, container, false)

        binding.liderpanosuRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        authViewModel.getUsers().observe(viewLifecycleOwner) { users ->
            val recyclerView = binding.liderpanosuRecyclerView
            val adapter = SettingsAdapter(users)
            recyclerView.adapter = adapter
        }

        authViewModel.getUserData()
        authViewModel.user.observe(viewLifecycleOwner) { data ->
            binding.apply {
                settingsNameTextView.text = "${data.name} ${data.surname}"
                SettingsScore.text = " Puan : ${data.score}"
                SettingsCountTrue.text = "  Doğru Sayısı : ${data.correctQuestionCount}"
                SettingsCountWrong.text = "  Yanlış Sayısı : ${data.wrongQuestionCount}"
            }
        }

        binding.settingsLogoutBtn.setOnClickListener {
            authViewModel.signOutViewModel { success ->
                startActivity(Intent(requireContext(), MainActivity::class.java))

            }
        }

        return binding.root
    }

}