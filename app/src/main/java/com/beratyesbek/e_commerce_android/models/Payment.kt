package com.beratyesbek.e_commerce_android.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*
@Parcelize
data class Payment(
    @SerializedName("paymentId")
    var paymentId: Number?,
    @SerializedName("cardNumber")
    var cardNumber: String,
    @SerializedName("cardHolderName")
    var cardHolderName: String,
    @SerializedName("expiryDate")
    var expiryDate: String,
    @SerializedName("cvv")
    var cvv: Int,
    @SerializedName("userId")
    var userId: Number,
    @SerializedName("address")
    var address: String,
    @SerializedName("phoneNumber")
    var phoneNumber: String,
    @SerializedName("productId")
    var productId: Number,
    @SerializedName("cartSummaryId")
    var cartSummaryId: Number,
    @SerializedName("totalPrice")
    var totalPrice: Int,
    @SerializedName("date")
    var date: Date,
    @SerializedName("email")
    var email: String
) : IEntity,Parcelable {



}