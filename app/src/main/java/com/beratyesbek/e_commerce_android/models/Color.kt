package com.beratyesbek.e_commerce_android.models

import com.google.gson.annotations.SerializedName

data class Color(
    @SerializedName("colorId")
    val colorId: Number,
    @SerializedName("colorName")
    val colorName: String,
    @SerializedName("colorCode")
    val colorCode: String
) {
}