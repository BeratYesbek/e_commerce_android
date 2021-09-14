package com.beratyesbek.e_commerce_android.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.beratyesbek.e_commerce_android.databinding.ActivityRegisterBinding
import com.beratyesbek.e_commerce_android.models.AccessToken
import com.beratyesbek.e_commerce_android.models.dtos.UserForRegisterDto
import com.beratyesbek.e_commerce_android.mvvm.RegisterViewModel
import com.beratyesbek.e_commerce_android.services.authService.AuthService
import com.beratyesbek.e_commerce_android.utilities.response.SingleResponseModel
import com.beratyesbek.e_commerce_android.utilities.sharedPreferences.CustomSharedPreferences
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class RegisterActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityRegisterBinding
    private val viewModel: RegisterViewModel by viewModels()
    private val authService = AuthService()
    private val disposable = CompositeDisposable()
    private val customSharedPreferences = CustomSharedPreferences(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = dataBinding.root
        setContentView(view)

        viewModel.result.observe(this, { result ->
            if (result) {
                val registerActivity = Intent(this, ProductActivity::class.java)
                startActivity(registerActivity)
                finish()
            }

        })

        dataBinding.btnSignUp.setOnClickListener {
            val firstName = dataBinding.editTextFirstName.text.toString()
            val lastName = dataBinding.editTextLastName.text.toString()
            val password = dataBinding.editTextPassword.text.toString()
            val email = dataBinding.editTextEmail.text.toString()

            viewModel.register(UserForRegisterDto(email, password, firstName, lastName))
        }

    }


}