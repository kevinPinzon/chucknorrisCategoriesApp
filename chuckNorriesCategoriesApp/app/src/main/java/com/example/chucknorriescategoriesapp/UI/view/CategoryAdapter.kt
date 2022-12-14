package com.example.chucknorriescategoriesapp.UI.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorriescategoriesapp.R

class CategoryAdapter(private var category: List<String>)  : RecyclerView.Adapter<CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInflate = LayoutInflater.from(parent.context)
        return CategoryViewHolder(layoutInflate.inflate(R.layout.item_category, parent, false))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = category[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = category.size

}