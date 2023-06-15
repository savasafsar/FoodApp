package com.example.foodapp.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide

import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentHomeBinding
import com.example.foodapp.model.Meal
import com.example.foodapp.model.MealList
import com.example.foodapp.retrofit.RetrofitInstance
import com.example.foodapp.viewModel.HomeViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {
    private lateinit var homeMvvm : HomeViewModel
private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeMvvm = ViewModelProviders.of(this)[HomeViewModel::class.java]




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeMvvm.getRandomMeal()
        observerRandomMeal()
        onRandomMealClick()
        

    }

    private fun onRandomMealClick() {
        binding.randomMeal.setOnClickListener {
            val intent = Intent(activity,MealActivity::class.java)
            startActivity(intent)


        }
    }

    private fun observerRandomMeal() {
        homeMvvm.observeRandomMealLivedata().observe(viewLifecycleOwner,object :Observer<Meal>{
            override fun onChanged(t: Meal?) {
               Glide.with(this@HomeFragment)
                   .load(t!!.strMealThumb)
                   .into(binding.imgRandomMeal)
            }

        })
    }


}