package com.beratyesbek.e_commerce_android.services.cartSummaryService

import com.beratyesbek.e_commerce_android.models.CartSummary
import com.beratyesbek.e_commerce_android.models.Product
import com.beratyesbek.e_commerce_android.models.dtos.CartSummaryDto
import com.beratyesbek.e_commerce_android.models.dtos.ProductDto
import com.beratyesbek.e_commerce_android.utilities.response.ListResponseModel
import com.beratyesbek.e_commerce_android.utilities.response.ResponseModel
import com.beratyesbek.e_commerce_android.utilities.response.SingleResponseModel
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ICartSummaryService {
    @POST("add")
    fun add(@Body entity: CartSummary): Single<ResponseModel>

    @POST("update")
    fun update(@Body entity: CartSummary): Single<ResponseModel>

    @POST("delete")
    fun delete(@Body entity: CartSummary): Single<ResponseModel>

    @GET("getById")
    fun getById(@Query("id") id: Number): Single<SingleResponseModel<CartSummary>>

    @GET("getAll")
    fun getAll(): Single<ListResponseModel<CartSummary>>

    @GET("getAllByUserId")
    fun getAllByUserId(@Query("id") id: Number): Single<ListResponseModel<CartSummary>>

    @GET("getCartSummaryDetailByUserId")
    fun getCartSummaryDetailByUserId(@Query("userId") userId: Number): Single<ListResponseModel<CartSummaryDto>>

}