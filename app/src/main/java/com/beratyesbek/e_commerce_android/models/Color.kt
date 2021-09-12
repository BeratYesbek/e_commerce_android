package com.beratyesbek.e_commerce_android.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Color(
    @SerializedName("colorId")
    val colorId: Number,
    @SerializedName("colorName")
    val colorName: String,
    @SerializedName("colorCode")
    val colorCode: String
) :IEntity,Parcelable{
}