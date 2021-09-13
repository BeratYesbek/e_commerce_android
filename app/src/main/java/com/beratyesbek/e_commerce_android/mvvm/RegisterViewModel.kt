package com.beratyesbek.e_commerce_android.mvvm

import android.app.Application
import com.beratyesbek.e_commerce_android.models.AccessToken
import com.beratyesbek.e_commerce_android.models.dtos.UserForRegisterDto
import com.beratyesbek.e_commerce_android.services.authService.AuthService
import com.beratyesbek.e_commerce_android.utilities.response.SingleResponseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class RegisterViewModel(application: Application) : BaseViewModel(application) {
    private val authService = AuthService()
    private val disposable = CompositeDisposable()


    fun register(registerDto: UserForRegisterDto){
        disposable.add(
            authService.register(registerDto)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<SingleResponseModel<AccessToken>>(){
                    override fun onSuccess(t: SingleResponseModel<AccessToken>) {
                        System.out.println(t.data?.token)
                    }
                    override fun onError(e: Throwable) {
                        System.out.println(e.message)
                    }

                })
        )
    }
}