package com.beratyesbek.e_commerce_android.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.beratyesbek.e_commerce_android.databinding.ActivityLoginBinding
import com.beratyesbek.e_commerce_android.models.AccessToken
import com.beratyesbek.e_commerce_android.models.dtos.UserForLoginDto
import com.beratyesbek.e_commerce_android.mvvm.LoginViewModel
import com.beratyesbek.e_commerce_android.services.authService.AuthService
import com.beratyesbek.e_commerce_android.utilities.response.SingleResponseModel
import com.beratyesbek.e_commerce_android.utilities.sharedPreferences.CustomSharedPreferences
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityLoginBinding

    private val viewModel : LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = ActivityLoginBinding.inflate(layoutInflater)
        val view = dataBinding.root
        setContentView(view)

        viewModel.result.observe(this,{
            if (it){
                val intentToProductActivity =
                    Intent(this, ProductActivity::class.java)
                startActivity(intentToProductActivity)
                finish()
            }else{
                Toast.makeText(
                    applicationContext,
                    "Email or Password is wrong",
                    Toast.LENGTH_LONG
                ).show()
            }
        })

        dataBinding.btnLoginActivitySignIn.setOnClickListener {
            val email = dataBinding.editTextLoginActivityEmail.text.toString()
            val password = dataBinding.editTextLoginActivityPassword.text.toString()
            viewModel.login(UserForLoginDto(email, password))
        }

        dataBinding.btnLoginActivitySignUp.setOnClickListener {
            val intentToRegisterActivity = Intent(this,RegisterActivity::class.java)
            startActivity(intentToRegisterActivity)
        }
    }





}