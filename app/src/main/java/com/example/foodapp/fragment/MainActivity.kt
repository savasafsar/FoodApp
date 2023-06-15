package com.example.foodapp.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.foodapp.R


import com.example.foodapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
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