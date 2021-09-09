package com.beratyesbek.e_commerce_android.models

import com.google.gson.annotations.SerializedName

class CartSummary(
    @SerializedName("id")
    val id :Number?,
    @SerializedName("productId")
    val productId:Number,
    @SerializedName("userId")
    val userId :Number
) : IEntity{
}