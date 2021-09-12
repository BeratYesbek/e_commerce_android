package com.beratyesbek.e_commerce_android.services.productService

import com.beratyesbek.e_commerce_android.models.Product
import com.beratyesbek.e_commerce_android.models.dtos.ProductDto
import com.beratyesbek.e_commerce_android.utilities.response.ListResponseModel
import com.beratyesbek.e_commerce_android.utilities.response.ResponseModel
import com.beratyesbek.e_commerce_android.utilities.response.SingleResponseModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IProductService {

    fun add(entity: Product): Single<ResponseModel>

    fun update(entity: Product): Single<ResponseModel>

    fun delete(entity: Product): Single<ResponseModel>

    @GET("getById")
    fun getById(@Query("id") id: Number): Single<SingleResponseModel<Product>>

    @GET("getProductDetailById")
    fun getProductDetailById(@Query("id") id: Number): Single<SingleResponseModel<ProductDto>>

    fun getAll(): Single<ListResponseModel<Product>>

    @GET("getAllProductDetail")
    fun getAllProductDetail(): Single<ListResponseModel<ProductDto>>
}