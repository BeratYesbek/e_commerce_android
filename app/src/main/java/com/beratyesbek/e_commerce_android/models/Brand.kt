package com.beratyesbek.e_commerce_android.models

import com.google.gson.annotations.SerializedName

data class Brand(
    @SerializedName("brandId")
    val brandId: Number,
    @SerializedName("brandName")
    val brandName: String,
    @SerializedName("brandImagePath")
    val brandImagePath : String
    ) : IEntity {
}