package com.beratyesbek.e_commerce_android.models

import com.google.gson.annotations.SerializedName

class Comment(
    @SerializedName("id")
    val id: Number,
    @SerializedName("userId")
    val userId: Number,
    @SerializedName("productId")
    val productId: Number,
    @SerializedName("rating")
    val rating: Number,
    @SerializedName("productComment")
    val productComment: String
) {

}