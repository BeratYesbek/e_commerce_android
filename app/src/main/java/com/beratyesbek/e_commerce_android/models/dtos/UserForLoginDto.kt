package com.beratyesbek.e_commerce_android.models.dtos

import com.google.gson.annotations.SerializedName


data class UserForLoginDto(
    @SerializedName("email")
    val email : String,
    @SerializedName("password")
    val password :String) {
}