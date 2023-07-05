package com.example.foodapp.retrofit

import com.example.foodapp.model.CategoryList
import com.example.foodapp.model.MealsByCategoryList
import com.example.foodapp.model.MealList
import com.example.foodapp.model.MealsByCategory
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {
//base url = "https://www.themealdb.com/api/json/v1/1/"

     @GET("random.php")
    fun getRandomMeal() : Call<MealList>

    @GET("lookup.php?")
    fun getMealDetails(@Query("i") id:String) : Call<MealList>

    @GET("filter.php?")
    fun getPopularItems(@Query("c") categoryName:String) :Call<MealsByCategoryList>

    @GET("categories.php")
    fun getCategories() : Call<CategoryList>

    @GET("filter.php")
    fun getMealsByCategory(@Query("c") categoryName: String) : Call<MealsByCategoryList>


}