package com.beratyesbek.e_commerce_android.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.beratyesbek.e_commerce_android.R
import com.beratyesbek.e_commerce_android.databinding.ActivityRegisterBinding
import com.beratyesbek.e_commerce_android.models.dtos.UserForRegisterDto
import com.beratyesbek.e_commerce_android.mvvm.LoginViewModel
import com.beratyesbek.e_commerce_android.mvvm.ProductViewModel
import com.beratyesbek.e_commerce_android.mvvm.RegisterViewModel

class RegisterActivity : AppCompatActivity() {

    private val viewModel: RegisterViewModel by viewModels()
    private lateinit var dataBinding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = dataBinding.root
        setContentView(view)
    }

    fun register(view: View) {
        val firstName = dataBinding.editTextFirstName.text.toString()
        val lastName = dataBinding.editTextLastName.text.toString()
        val password = dataBinding.editTextPassword.text.toString()
        val email = dataBinding.editTextEmail.text.toString()

        viewModel.register(UserForRegisterDto(email, password, firstName, lastName))
    }
}