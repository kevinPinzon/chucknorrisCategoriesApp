package com.example.chucknorriescategoriesapp.model

import com.google.gson.annotations.SerializedName

data class ResponseMode(
    @SerializedName("") var categories: List<String>
)