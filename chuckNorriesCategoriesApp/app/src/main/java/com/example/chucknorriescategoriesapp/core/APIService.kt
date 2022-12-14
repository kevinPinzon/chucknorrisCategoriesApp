package com.example.chucknorriescategoriesapp.core

import com.example.chucknorriescategoriesapp.model.CategoryModel
import com.example.chucknorriescategoriesapp.model.ResponseMode
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {

    @GET
    suspend fun getCategories(@Url url:String): Response<List<String>>

    @GET
    suspend fun getCategoryDetails(@Url url:String): Response<CategoryModel>

}