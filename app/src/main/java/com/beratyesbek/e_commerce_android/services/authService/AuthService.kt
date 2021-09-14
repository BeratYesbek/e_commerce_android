package com.beratyesbek.e_commerce_android.services.authService

import com.beratyesbek.e_commerce_android.models.AccessToken
import com.beratyesbek.e_commerce_android.models.dtos.UserForLoginDto
import com.beratyesbek.e_commerce_android.models.dtos.UserForRegisterDto
import com.beratyesbek.e_commerce_android.services.Api
import com.beratyesbek.e_commerce_android.utilities.response.SingleResponseModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class AuthService : IAuthService {

    private val api = Retrofit.Builder().baseUrl(Api.BASE_URL + "auth/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(IAuthService::class.java)

    override fun login(entity: UserForLoginDto): Single<SingleResponseModel<AccessToken>> {
        return api.login(entity)
    }

    override fun register(entity: UserForRegisterDto): Single<SingleResponseModel<AccessToken>>  {
        return api.register(entity)
    }
}