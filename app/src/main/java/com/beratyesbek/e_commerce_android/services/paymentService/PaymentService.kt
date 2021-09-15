package com.beratyesbek.e_commerce_android.services.paymentService

import com.beratyesbek.e_commerce_android.models.Payment
import com.beratyesbek.e_commerce_android.services.Api
import com.beratyesbek.e_commerce_android.utilities.response.ListResponseModel
import com.beratyesbek.e_commerce_android.utilities.response.ResponseModel
import com.beratyesbek.e_commerce_android.utilities.response.SingleResponseModel
import io.reactivex.Single

class PaymentService : IPaymentService {

    private val api = Api.api<IPaymentService, Payment>()

    override fun add(entity: ArrayList<Payment>): Single<ResponseModel> {
        return api.add(entity)
    }

    override fun update(entity: Payment): Single<ResponseModel> {
        return api.update(entity)
    }

    override fun delete(entity: Payment): Single<ResponseModel> {
        return api.update(entity)
    }

    override fun getById(id: Number): Single<SingleResponseModel<Payment>> {
        return api.getById(id)
    }

    override fun getAll(): Single<ListResponseModel<Payment>> {
        return api.getAll()
    }
}