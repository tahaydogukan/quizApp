package com.tahayasindogukan.quizapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.tahayasindogukan.quizapp.R
import com.tahayasindogukan.quizapp.databinding.ActivityHomeBinding
import com.tahayasindogukan.quizapp.viewmodel.WordViewModel

class HomeActivity : AppCompatActivity() {
    private lateinit var binding:ActivityHomeBinding
    private lateinit var navController:NavController
    private lateinit var wordViewModel: WordViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tempViewModel:WordViewModel by viewModels()
        wordViewModel=tempViewModel

        navController=Navigation.findNavController(this,R.id.homeFragmentContainerView)
        NavigationUI.setupWithNavController(binding.homeBottomNavigation,navController)


    }


}