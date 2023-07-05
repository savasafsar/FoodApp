package com.example.foodapp.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.foodapp.R


import com.example.foodapp.databinding.ActivityMainBinding
import com.example.foodapp.db.MealDatabase
import com.example.foodapp.viewModel.HomeViewModel
import com.example.foodapp.viewModel.HomeViewModelFactory

class MainActivity : AppCompatActivity() {
  val viewModel: HomeViewModel by lazy {
      val mealDatabase = MealDatabase.getInstance(this)
      val homeViewModelProviderFactory = HomeViewModelFactory(mealDatabase)
      ViewModelProvider(this,homeViewModelProviderFactory)[HomeViewModel::class.java]
  }
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val bottomNavigation = binding.btmNav
        val navController = Navigation.findNavController(this, R.id.host_fragment)


        NavigationUI.setupWithNavController(bottomNavigation, navController)



    }

}