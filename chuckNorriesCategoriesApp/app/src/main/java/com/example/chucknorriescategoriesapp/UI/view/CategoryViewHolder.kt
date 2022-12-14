package com.example.chucknorriescategoriesapp.UI.view

import android.app.Dialog
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView

import com.example.chucknorriescategoriesapp.core.APIService
import com.example.chucknorriescategoriesapp.core.RetrofitHelper
import com.example.chucknorriescategoriesapp.databinding.ItemCategoryBinding
import com.example.chucknorriescategoriesapp.model.CategoryModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = ItemCategoryBinding.bind(itemView)

    fun bind(categoryName:String) {
        binding.tvCategory.text = categoryName

        binding.root.setOnClickListener {
            getCategories(categoryName)
        }

    }

    fun getCategories(category:String) {
        var intent = Intent(itemView.context, CategoryDetailsActivity::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitHelper().getCategoriesApi().create(APIService::class.java).getCategoryDetails("random?category=$category")
            val resultCategory: CategoryModel = call.body()!!
            intent.putExtra("categoryName", category)
            intent.putExtra("categoryDescription", resultCategory.description)

            itemView.context.startActivity(intent)
        }
    }

}