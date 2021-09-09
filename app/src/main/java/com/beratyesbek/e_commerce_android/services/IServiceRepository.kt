package com.beratyesbek.e_commerce_android.services

import com.beratyesbek.e_commerce_android.models.IEntity
import com.beratyesbek.e_commerce_android.models.Product
import com.beratyesbek.e_commerce_android.services.productService.ProductManager
import com.beratyesbek.e_commerce_android.utilities.response.ListResponseModel
import com.beratyesbek.e_commerce_android.utilities.response.ResponseModel
import com.beratyesbek.e_commerce_android.utilities.response.SingleResponseModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import java.util.*
import kotlin.reflect.KProperty
import kotlin.reflect.cast

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
