package com.beratyesbek.e_commerce_android.services.productService

import com.beratyesbek.e_commerce_android.models.Country
import com.beratyesbek.e_commerce_android.models.IEntity
import com.beratyesbek.e_commerce_android.models.Product
import com.beratyesbek.e_commerce_android.models.dtos.ProductDto
import com.beratyesbek.e_commerce_android.services.Api
import com.beratyesbek.e_commerce_android.services.IServiceRepository
import com.beratyesbek.e_commerce_android.utilities.response.ListResponseModel
import com.beratyesbek.e_commerce_android.utilities.response.ResponseModel
import com.beratyesbek.e_commerce_android.utilities.response.SingleResponseModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST

open class ProductManager : IProductService {


    private val api = Api.api<IProductService, Product>()


    override fun getAll(): Single<ListResponseModel<Product>> {
        return api.getAll()
    }

    override fun getAllProductDetail(): Single<ListResponseModel<ProductDto>> {
        return api.getAllProductDetail()
    }

    override fun getById(id: Number): Single<SingleResponseModel<Product>> {
        return api.getById(id)
    }

    override fun add(entity: Product): Single<ResponseModel> {
        TODO("Not yet implemented")
    }

    override fun update(product: Product): Single<ResponseModel> {
        TODO("Not yet implemented")
    }

    override fun delete(product: Product): Single<ResponseModel> {
        TODO("Not yet implemented")
    }


}