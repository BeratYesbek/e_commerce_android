package com.beratyesbek.e_commerce_android.models

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("productName")
    val productName : String?,
    @SerializedName("productDescription")
    val productDescription : String?,
    @SerializedName("productPrice")
    val productPrice : Number?,
    @SerializedName("productQuantity")
    val productQuantity : Number,
    @SerializedName("brandId")
    val brandId : Number?,
    @SerializedName("colorId")
    val colorId : Number?,
    @SerializedName("categoryId")
    val categoryId : Number?,
) : IEntity {


}