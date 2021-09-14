package com.beratyesbek.e_commerce_android.utilities.sharedPreferences

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.core.content.edit
import com.beratyesbek.e_commerce_android.models.AccessToken

class CustomSharedPreferences {

    companion object {

        private var sharedPreferences: SharedPreferences? = null

        @Volatile
        private var instance: CustomSharedPreferences? = null
        private val lock = Any()

        operator fun invoke(context: Context): CustomSharedPreferences =
            instance ?: synchronized(lock) {
                instance ?: makeSharedPreferences(context).also {
                    instance = it
                }
            }

        private fun makeSharedPreferences(context: Context): CustomSharedPreferences {
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            return CustomSharedPreferences()
        }
    }

    fun saveToken(accessToken: AccessToken) {
        sharedPreferences?.edit(commit = true) {
            putString("token", accessToken.token)
            putString("date", accessToken.date.toString())
            putInt("userId", accessToken.user.userId)
        }
    }

    fun getToken() = sharedPreferences?.getString("token", "")
    fun getUserId() = sharedPreferences?.getInt("userId", 0)
    fun getDate() = sharedPreferences?.getString("date", "")
}