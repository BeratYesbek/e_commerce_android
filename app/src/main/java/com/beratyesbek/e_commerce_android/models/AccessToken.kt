package com.beratyesbek.e_commerce_android.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class AccessToken(
    @SerializedName("token")
    val token :String,
    @SerializedName("date")
    val date : Date,
    @SerializedName("user")
    val user:User
) {
}