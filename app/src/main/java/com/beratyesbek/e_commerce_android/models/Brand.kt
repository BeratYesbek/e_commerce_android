package com.beratyesbek.e_commerce_android.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Brand(
    @SerializedName("brandId")
    val brandId: Number,
    @SerializedName("brandName")
    val brandName: String,
    @SerializedName("brandImagePath")
    val brandImagePath : String
    ) : IEntity,Parcelable {
}