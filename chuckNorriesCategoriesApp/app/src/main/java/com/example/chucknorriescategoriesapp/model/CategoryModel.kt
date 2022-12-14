package com.example.chucknorriescategoriesapp.model

import com.google.gson.annotations.SerializedName

data class CategoryModel(
    @SerializedName("categories") var categories: List<String>,
    @SerializedName("icon_url") var icon: String,
    @SerializedName("id") var id: String,
    @SerializedName("url") var url: String,
    @SerializedName("value") var description: String
)