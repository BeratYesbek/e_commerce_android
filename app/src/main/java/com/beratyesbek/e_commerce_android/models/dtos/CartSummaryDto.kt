package com.beratyesbek.e_commerce_android.models.dtos

import com.beratyesbek.e_commerce_android.models.Brand
import com.beratyesbek.e_commerce_android.models.Category
import com.beratyesbek.e_commerce_android.models.Color
import com.beratyesbek.e_commerce_android.models.Product
import com.google.gson.annotations.SerializedName

data class CartSummaryDto(
    @SerializedName("id")
    val  id : Number ,
    @SerializedName("productId")
    val  productId : Number,
    @SerializedName("userId")
    val  userId : Number ,
    @SerializedName("category")
    val category: Category,
    @SerializedName("brand")
    val brand: Brand,
    @SerializedName("color")
    val color: Color,
    @SerializedName("product")
    val product :Product,
    @SerializedName("images")
    val images : List<String>

) {
}