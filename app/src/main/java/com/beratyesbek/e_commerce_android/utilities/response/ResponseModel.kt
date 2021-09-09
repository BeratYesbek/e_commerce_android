package com.beratyesbek.e_commerce_android.utilities.response

import com.google.gson.annotations.SerializedName

open class ResponseModel(
    @SerializedName("success")
    val success:Boolean,
    @SerializedName("message")
    val message:String?
){

}