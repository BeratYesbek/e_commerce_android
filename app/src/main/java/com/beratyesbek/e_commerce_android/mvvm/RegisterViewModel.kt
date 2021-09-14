package com.beratyesbek.e_commerce_android.mvvm

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.beratyesbek.e_commerce_android.models.AccessToken
import com.beratyesbek.e_commerce_android.models.dtos.UserForRegisterDto
import com.beratyesbek.e_commerce_android.services.authService.AuthService
import com.beratyesbek.e_commerce_android.utilities.response.SingleResponseModel
import com.beratyesbek.e_commerce_android.utilities.sharedPreferences.CustomSharedPreferences
import com.beratyesbek.e_commerce_android.utilities.sharedPreferences.SharedPreferencesToken
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class RegisterViewModel(application: Application) : BaseViewModel(application) {
    private val authService = AuthService()
    private val disposable = CompositeDisposable()
    val result = MutableLiveData<Boolean>()
    private val customSharedPreferences = CustomSharedPreferences(application)

    fun register(registerDto: UserForRegisterDto){
        disposable.add(
            authService.register(registerDto)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<SingleResponseModel<AccessToken>>(){
                    override fun onSuccess(t: SingleResponseModel<AccessToken>) {
                        result.value = t.success
                        if (t.success) {
                            customSharedPreferences.saveToken(t.data!!)
                            SharedPreferencesToken.token = t.data.token
                            SharedPreferencesToken.date = t.data.date
                            SharedPreferencesToken.userId = t.data.user.userId
                        }                 }
                    override fun onError(e: Throwable) {
                        System.out.println(e.message)
                    }

                })
        )
    }
}