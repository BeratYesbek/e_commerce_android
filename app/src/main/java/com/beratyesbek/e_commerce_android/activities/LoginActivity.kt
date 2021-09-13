package com.beratyesbek.e_commerce_android.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.beratyesbek.e_commerce_android.R
import com.beratyesbek.e_commerce_android.databinding.ActivityLoginBinding
import com.beratyesbek.e_commerce_android.models.dtos.UserForLoginDto
import com.beratyesbek.e_commerce_android.mvvm.LoginViewModel
import com.beratyesbek.e_commerce_android.mvvm.RegisterViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding = ActivityLoginBinding.inflate(layoutInflater)
        val view = dataBinding.root
        setContentView(view)

        dataBinding.btnSignUp.setOnClickListener {
            val intentToRegisterActivity = Intent(this,RegisterActivity::class.java)
            startActivity(intentToRegisterActivity)
        }

    }

    fun login(view :View) {
        val email = dataBinding.editTextLoginEmail.text.toString()
        val password = dataBinding.editTextLoginPassword.text.toString()

        viewModel.login(UserForLoginDto(email,password))
    }
}