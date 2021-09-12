package com.beratyesbek.e_commerce_android.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.beratyesbek.e_commerce_android.R
import com.beratyesbek.e_commerce_android.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var dataBinding :ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding = ActivityLoginBinding.inflate(layoutInflater)
        val view = dataBinding.root
        setContentView(view)

        dataBinding.btnSignIn.setOnClickListener {
            val intentToLoginActivity = Intent(this,ProductActivity::class.java)
            startActivity(intentToLoginActivity)
        }
    }
}