package com.beratyesbek.e_commerce_android.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.beratyesbek.e_commerce_android.R
import com.beratyesbek.e_commerce_android.mvvm.MainViewModel
import com.beratyesbek.e_commerce_android.utilities.connections.NetworkConnection
import com.beratyesbek.e_commerce_android.utilities.sharedPreferences.CustomSharedPreferences

class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        when (NetworkConnection.isNetworkAvailable(this)) {
            true -> {

               when(viewModel.getTokenFromSharedPreferences()){
                    true-> {
                        var intentToProductActivity = Intent(this, ProductActivity::class.java)
                        startActivity(intentToProductActivity)
                        finish()
                    }
                    false->{
                        var intentToLoginActivity = Intent(this, LoginActivity::class.java)
                        startActivity(intentToLoginActivity)
                        finish()
                    }
                }

            }
            false -> {
                Toast.makeText(this, "Please check your internet connection", Toast.LENGTH_LONG)
                    .show()
            }
        }

    }


}