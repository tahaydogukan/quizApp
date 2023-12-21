package com.tahayasindogukan.quizapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.tahayasindogukan.quizapp.R
import com.tahayasindogukan.quizapp.databinding.FragmentSignUpBinding
import com.tahayasindogukan.quizapp.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController

    private val viewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        binding.signUpButton.setOnClickListener {
            val email = binding.editEmailSignUp.text.toString()
            val password = binding.editPasswordSignUp.text.toString()

            viewModel.signUpViewModel(email, password) { success, message ->
                if (email.isNotEmpty() && password.isNotEmpty()) {
                    navController.navigate(R.id.action_signUpFragment_to_signInFragment)
                }
            }
        }

        binding.signUpText.setOnClickListener {
            navController.navigate(R.id.action_signUpFragment_to_signInFragment)
        }


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}