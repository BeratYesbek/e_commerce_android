package com.beratyesbek.e_commerce_android.mvvm

import android.app.Application
import com.beratyesbek.e_commerce_android.utilities.sharedPreferences.CustomSharedPreferences
import com.beratyesbek.e_commerce_android.utilities.sharedPreferences.SharedPreferencesToken
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class MainViewModel(application: Application) : BaseViewModel(application) {

    private val customSharedPreferences = CustomSharedPreferences(application)

    fun getTokenFromSharedPreferences(): Boolean {
        val token = customSharedPreferences.getToken()
        var date: Date? = null
        if (customSharedPreferences.getDate() != null) {
            date = Date(customSharedPreferences.getDate()!!)

        }
        SharedPreferencesToken.date = date
        SharedPreferencesToken.userId = customSharedPreferences.getUserId()
        SharedPreferencesToken.token = token
        if (!token.isNullOrBlank()) {
            return true
        }
        return false
    }
}