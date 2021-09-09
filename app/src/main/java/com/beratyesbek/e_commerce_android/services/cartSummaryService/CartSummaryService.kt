package com.beratyesbek.e_commerce_android.services.cartSummaryService

import com.beratyesbek.e_commerce_android.models.CartSummary
import com.beratyesbek.e_commerce_android.services.Api
import com.beratyesbek.e_commerce_android.utilities.response.ListResponseModel
import com.beratyesbek.e_commerce_android.utilities.response.ResponseModel
import com.beratyesbek.e_commerce_android.utilities.response.SingleResponseModel
import io.reactivex.Single

class CartSummaryService : ICartSummaryService {


    private val api = Api.api<ICartSummaryService,CartSummary>()

    override fun add(entity: CartSummary): Single<ResponseModel> {
      return api.add(entity)
    }

    override fun update(entity: CartSummary): Single<ResponseModel> {
        TODO("Not yet implemented")
    }

    override fun delete(entity: CartSummary): Single<ResponseModel> {
        TODO("Not yet implemented")
    }

    override fun getById(id: Number): Single<SingleResponseModel<CartSummary>> {
        TODO("Not yet implemented")
    }

    override fun getAll(): Single<ListResponseModel<CartSummary>> {
        TODO("Not yet implemented")
    }

    override fun getAllByUserId(id: Number): Single<ListResponseModel<CartSummary>> {
      return api.getAllByUserId(id)
    }
}