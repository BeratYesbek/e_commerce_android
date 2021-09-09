package com.beratyesbek.e_commerce_android.utilities.response

import com.beratyesbek.e_commerce_android.models.Product
import com.google.gson.annotations.SerializedName

class SingleResponseModel<T>(
     val data: T?,
     success:Boolean,
     message:String?
): ResponseModel(success,message) {
}