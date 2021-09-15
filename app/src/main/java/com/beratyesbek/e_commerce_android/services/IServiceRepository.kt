package com.beratyesbek.e_commerce_android.services

import com.beratyesbek.e_commerce_android.utilities.response.ListResponseModel
import com.beratyesbek.e_commerce_android.utilities.response.ResponseModel
import com.beratyesbek.e_commerce_android.utilities.response.SingleResponseModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface IServiceRepository<T> {

    @POST("add")
    fun  add(entity: T): Single<ResponseModel>

    @POST("update")
    fun  update(entity: T): Single<ResponseModel>

    @POST("delete")
    fun  delete(entity: T): Single<ResponseModel>

    @GET("getById")
    fun  getById(@Query("id") id: Number): Single<SingleResponseModel<T>>

    @GET("getAll")
    fun  getAll(): Single<ListResponseModel<T>>
}
