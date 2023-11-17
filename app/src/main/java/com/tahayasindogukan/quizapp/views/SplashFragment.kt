package com.tahayasindogukan.quizapp.views

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.tahayasindogukan.quizapp.R

class SplashFragment : Fragment() {
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController= Navigation.findNavController(view)
        Handler(Looper.getMainLooper()).postDelayed({
            navController.navigate(R.id.action_splashFragment_to_signUpFragment)

        }, 2000) // 2000 milisaniye (2 saniye) sonra geçiş yapacak
    }

    }
