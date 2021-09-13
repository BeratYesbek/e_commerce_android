package com.beratyesbek.e_commerce_android.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("userId")
    val userId :Int,
    @SerializedName("firstName")
    val firstName:String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("email")
    val email: String
) {
}