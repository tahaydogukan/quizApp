package com.tahayasindogukan.quizapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.tahayasindogukan.quizapp.R
import com.tahayasindogukan.quizapp.databinding.ActivityHomeBinding
import com.tahayasindogukan.quizapp.viewmodel.WordViewModel
import dagger.hilt.android.AndroidEntryPoint

class HomeActivity : AppCompatActivity() {
    private lateinit var binding:ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment=supportFragmentManager.findFragmentById(R.id.homeFragmentContainerView) as NavHostFragment
        NavigationUI.setupWithNavController(binding.homeBottomNavigation,navHostFragment.navController)



    }


}