package com.beratyesbek.e_commerce_android.models.dtos

import com.google.gson.annotations.SerializedName

data class UserForRegisterDto(
    @SerializedName("email")
    val email : String,
    @SerializedName("password")
    val password :String,
    @SerializedName("firstName")
    val firstName :String,
    @SerializedName("lastName")
    val lastName :String
) {
}