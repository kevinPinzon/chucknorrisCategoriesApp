package com.example.chucknorriescategoriesapp.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chucknorriescategoriesapp.UI.view.CategoryAdapter
import com.example.chucknorriescategoriesapp.UI.viewModel.CategoryViewModel
import com.example.chucknorriescategoriesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CategoryAdapter
    private val categoryViewModel: CategoryViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        categoryViewModel.getCategories()

        categoryViewModel.categoriesModel.observe(this) {
            binding.recycler.adapter = CategoryAdapter(it)
            binding.recycler.adapter?.notifyDataSetChanged()
        }

        initRecycler()
    }

    private fun initRecycler() {
        adapter = CategoryAdapter(categoryViewModel.categoriesModel.value?: emptyList())
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter
    }
}