package com.beratyesbek.e_commerce_android.services.authService

import com.beratyesbek.e_commerce_android.models.AccessToken
import com.beratyesbek.e_commerce_android.models.Product
import com.beratyesbek.e_commerce_android.models.dtos.ProductDto
import com.beratyesbek.e_commerce_android.models.dtos.UserForLoginDto
import com.beratyesbek.e_commerce_android.models.dtos.UserForRegisterDto
import com.beratyesbek.e_commerce_android.utilities.response.ListResponseModel
import com.beratyesbek.e_commerce_android.utilities.response.ResponseModel
import com.beratyesbek.e_commerce_android.utilities.response.SingleResponseModel
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface IAuthService{
    @POST("login")
    fun login(@Body entity: UserForLoginDto): Single<SingleResponseModel<AccessToken>>
    @POST("register")
    fun register(@Body entity: UserForRegisterDto): Single<SingleResponseModel<AccessToken>>

}