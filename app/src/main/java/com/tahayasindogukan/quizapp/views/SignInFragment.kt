package com.tahayasindogukan.quizapp.views

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.tahayasindogukan.quizapp.R
import com.tahayasindogukan.quizapp.activities.HomeActivity
import com.tahayasindogukan.quizapp.databinding.FragmentSignInBinding
import com.tahayasindogukan.quizapp.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

class SignInFragment : Fragment() {

    private var _binding:FragmentSignInBinding?=null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding= FragmentSignInBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController= Navigation.findNavController(view)

        binding.signInText.setOnClickListener{
            navController.navigate(R.id.action_signInFragment_to_signUpFragment)
        }

        binding.signInButton.setOnClickListener{
            val email=binding.editEmailSignIn.text.toString()
            val password=binding.editPasswordSignIn.text.toString()

            viewModel.signInViewModel(email,password){ success, message ->

                if (success) {
                    // Giriş başarılı, ek işlemleri yapabilirsiniz.
                    val user = viewModel.currentUserViewModel()
                    // User nesnesini kullanabilir veya UI'yi güncelleyebilirsiniz.
                    startActivity(Intent(requireContext(),HomeActivity::class.java))
                } else {
                    // Giriş başarısız, kullanıcıya hata mesajı gösterilebilir.
                    Toast.makeText(requireContext(), "Giriş başarısız: $message", Toast.LENGTH_SHORT).show()
                }

                }
            }

        }

    }

