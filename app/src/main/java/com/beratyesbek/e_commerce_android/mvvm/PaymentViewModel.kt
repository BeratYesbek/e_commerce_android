package com.beratyesbek.e_commerce_android.mvvm

import android.app.Application
import android.widget.Toast
import com.beratyesbek.e_commerce_android.models.CartSummary
import com.beratyesbek.e_commerce_android.models.Payment
import com.beratyesbek.e_commerce_android.services.cartSummaryService.CartSummaryService
import com.beratyesbek.e_commerce_android.services.paymentService.PaymentService
import com.beratyesbek.e_commerce_android.utilities.response.ResponseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope

class PaymentViewModel(application: Application) : BaseViewModel(application), CoroutineScope {

    private val paymentService = PaymentService()
    private val cartSummaryService = CartSummaryService()
    private val disposable = CompositeDisposable()

    fun add(paymentList: ArrayList<Payment>) {
        disposable.add(
            paymentService.add(paymentList)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<ResponseModel>() {
                    override fun onSuccess(t: ResponseModel) {
                        if (t.success) {
                            Toast.makeText(
                                getApplication(),
                                "Payment completed successfully",
                                Toast.LENGTH_LONG
                            ).show()
                            deleteCartSummary(paymentList)
                        }
                    }

                    override fun onError(e: Throwable) {
                        Toast.makeText(
                            getApplication(),
                            "Payment did not complete",
                            Toast.LENGTH_LONG
                        ).show()
                        System.out.println(e.message)
                    }

                })
        )
    }

    fun deleteCartSummary(paymentList: ArrayList<Payment>) {
        for (item in paymentList) {
            disposable.add(
                cartSummaryService.delete(CartSummary(item.cartSummaryId, item.productId, item.userId))
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object :DisposableSingleObserver<ResponseModel>(){
                        override fun onSuccess(t: ResponseModel) {

                        }

                        override fun onError(e: Throwable) {

                        }

                    })
            )
        }

    }
}