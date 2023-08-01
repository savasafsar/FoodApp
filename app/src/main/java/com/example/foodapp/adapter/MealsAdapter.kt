package com.example.foodapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodapp.databinding.MealItemBinding
import com.example.foodapp.downloadFromUrl
import com.example.foodapp.model.Meal
import com.example.foodapp.placeholderProgressBar

class MealsAdapter: RecyclerView.Adapter<MealsAdapter.FavoriteMealsAdapterViewHolder>() {

    inner class FavoriteMealsAdapterViewHolder(val binding:MealItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffUtil = object :DiffUtil.ItemCallback<Meal>(){
        override fun areItemsTheSame(oldItem: Meal, newItem: Meal): Boolean {
            return oldItem.idMeal == newItem.idMeal
        }

        override fun areContentsTheSame(oldItem: Meal, newItem: Meal): Boolean {
            return oldItem==newItem
        }

    }

    val differ = AsyncListDiffer(this,diffUtil)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteMealsAdapterViewHolder {
        return FavoriteMealsAdapterViewHolder(MealItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: FavoriteMealsAdapterViewHolder, position: Int) {

        val meal = differ.currentList[position]

        holder.binding.tvMealName.text = meal.strMeal
        holder.binding.imgMeal.downloadFromUrl(meal.strMealThumb, placeholderProgressBar(holder.itemView.context))
    }


}