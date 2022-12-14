package com.example.chucknorriescategoriesapp.UI.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chucknorriescategoriesapp.core.APIService
import com.example.chucknorriescategoriesapp.core.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryViewModel : ViewModel() {

    val categoriesModel = MutableLiveData<List<String>>()

    fun getCategories() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitHelper().getCategoriesApi().create(APIService::class.java).getCategories("categories")
            val resultCategories = call.body()
            categoriesModel.postValue(resultCategories ?: emptyList())
        }
    }

}