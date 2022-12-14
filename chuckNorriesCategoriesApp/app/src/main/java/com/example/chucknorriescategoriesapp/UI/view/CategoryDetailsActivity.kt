package com.example.chucknorriescategoriesapp.UI.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chucknorriescategoriesapp.databinding.ActivityCategoryDetailsBinding
import com.example.chucknorriescategoriesapp.databinding.ActivityMainBinding

class CategoryDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCategoryDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var categoryName: String? = intent.getStringExtra("categoryName")
        var categoryDescription: String? = intent.getStringExtra("categoryDescription")

        binding.tvName.text = categoryName
        binding.tvDescription.text = categoryDescription

    }
}