package com.beratyesbek.e_commerce_android.services.paymentService

import com.beratyesbek.e_commerce_android.models.Payment
import com.beratyesbek.e_commerce_android.models.Product
import com.beratyesbek.e_commerce_android.models.dtos.ProductDto
import com.beratyesbek.e_commerce_android.utilities.response.ListResponseModel
import com.beratyesbek.e_commerce_android.utilities.response.ResponseModel
import com.beratyesbek.e_commerce_android.utilities.response.SingleResponseModel
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface IPaymentService  {

    @POST("add")
    fun add(@Body entity: ArrayList<Payment>): Single<ResponseModel>

    @POST("update")
    fun update(@Body entity: Payment): Single<ResponseModel>

    @POST("delete")
    fun delete(@Body entity: Payment): Single<ResponseModel>

    @GET("getById")
    fun getById(@Query("id") id: Number): Single<SingleResponseModel<Payment>>

    @GET("getAll")
    fun getAll(): Single<ListResponseModel<Payment>>


}