package com.beratyesbek.e_commerce_android.models.dtos

import com.beratyesbek.e_commerce_android.models.Comment
import com.google.gson.annotations.SerializedName

class ProductDto(
    @SerializedName("productId")
    val productId : Number,
    @SerializedName("productDescription")
    val productDescription : String,
    @SerializedName("productName")
    val productName : String,
    @SerializedName("productPrice")
    val productPrice : Number,
    @SerializedName("productQuantity")
    val productQuantity : Number,
    @SerializedName("categoryId")
    val categoryId : Number,
    @SerializedName("categoryName")
    val categoryName : String,
    @SerializedName("brandName")
    val brandName : String,
    @SerializedName("brandId")
    val brandId :String,
    @SerializedName("brandLogo")
    val brandLogo :String,
    @SerializedName("colorCode")
    val colorCode :String,
    @SerializedName("colorName")
    val colorName :String,
    @SerializedName("colorId")
    val colorId :Number,
    @SerializedName("images")
    val images : List<String>,
    @SerializedName("comments")
    val comments : List<Comment>) {
}