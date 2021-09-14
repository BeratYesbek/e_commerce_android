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
    private val authService = AuthService()
    private val disposable = CompositeDisposable()
    private val customSharedPreferences = CustomSharedPreferences(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = dataBinding.root
        setContentView(view)

        dataBinding.btnSignUp.setOnClickListener {
            val firstName = dataBinding.editTextFirstName.text.toString()
            val lastName = dataBinding.editTextLastName.text.toString()
            val password = dataBinding.editTextPassword.text.toString()
            val email = dataBinding.editTextEmail.text.toString()

            register(UserForRegisterDto(email, password, firstName, lastName))
        }


    }


    fun register(registerDto: UserForRegisterDto) {
        disposable.add(
            authService.register(registerDto)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :
                    DisposableSingleObserver<SingleResponseModel<AccessToken>>() {
                    override fun onSuccess(t: SingleResponseModel<AccessToken>) {
                        if (t.success) {
                            customSharedPreferences.saveToken(t.data!!)
                            val intentToProductActivity =
                                Intent(this@RegisterActivity, ProductActivity::class.java)
                            startActivity(intentToProductActivity)
                        } else {
                            Toast.makeText(this@RegisterActivity, t.message, Toast.LENGTH_LONG)
                                .show()
                        }
                    }

                    override fun onError(e: Throwable) {
                        System.out.println(e.message)
                    }

                })
        )
    }
}