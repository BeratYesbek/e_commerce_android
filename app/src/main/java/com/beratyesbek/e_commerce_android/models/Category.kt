package com.beratyesbek.e_commerce_android.models

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("categoryId")
    val categoryId :String,
    @SerializedName("categoryName")
    val categoryName :String
) {
}