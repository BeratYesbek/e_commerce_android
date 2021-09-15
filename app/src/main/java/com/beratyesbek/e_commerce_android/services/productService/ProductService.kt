package com.beratyesbek.e_commerce_android.services.productService

import com.beratyesbek.e_commerce_android.models.Product
import com.beratyesbek.e_commerce_android.models.dtos.ProductDto
import com.beratyesbek.e_commerce_android.services.Api
import com.beratyesbek.e_commerce_android.utilities.response.ListResponseModel
import com.beratyesbek.e_commerce_android.utilities.response.ResponseModel
import com.beratyesbek.e_commerce_android.utilities.response.SingleResponseModel
import io.reactivex.Single

open class ProductService : IProductService {


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

    override fun getProductDetailById(id: Number): Single<SingleResponseModel<ProductDto>> {
        return api.getProductDetailById(id)
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