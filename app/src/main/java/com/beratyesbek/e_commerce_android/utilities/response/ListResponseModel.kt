package com.beratyesbek.e_commerce_android.utilities.response

class ListResponseModel<T>(
    val data: List<T>?,
    success:Boolean,
    message:String?
) :ResponseModel(success,message) {
}