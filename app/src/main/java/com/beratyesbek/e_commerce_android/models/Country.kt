package com.beratyesbek.e_commerce_android.models

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("name")
    val countryName: String?,
    @SerializedName("region")
    val countryRegion: String?,
    @SerializedName("capital")
    val countryCapital: String?,
    @SerializedName("currency")
    val countryCurrency: String?,
    @SerializedName("language")
    val countryLanguage: String?,
    @SerializedName("flag")
    val imageUrl: String?) {



}