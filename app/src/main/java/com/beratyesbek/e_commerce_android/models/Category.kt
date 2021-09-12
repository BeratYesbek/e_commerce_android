package com.beratyesbek.e_commerce_android.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(
    @SerializedName("categoryId")
    val categoryId :String,
    @SerializedName("categoryName")
    val categoryName :String
) : Parcelable,IEntity {
}