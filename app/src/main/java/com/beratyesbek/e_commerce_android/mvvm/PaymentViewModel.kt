package com.beratyesbek.e_commerce_android.mvvm

import android.app.Application
import android.widget.Toast
import com.beratyesbek.e_commerce_android.models.Payment
import com.beratyesbek.e_commerce_android.services.paymentService.PaymentManager
import com.beratyesbek.e_commerce_android.utilities.response.ResponseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class PaymentViewModel(application: Application) : BaseViewModel(application),CoroutineScope {

    private val paymentService = PaymentManager()
    private val disposable = CompositeDisposable()

    fun add(paymentList : List<Payment>){
        disposable.add(
            paymentService.add(paymentList)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<ResponseModel>(){
                    override fun onSuccess(t: ResponseModel) {
                        if (t.success){
                            Toast.makeText(getApplication(),"Payment completed successfully",Toast.LENGTH_LONG).show()
                        }
                    }

                    override fun onError(e: Throwable) {
                        Toast.makeText(getApplication(),"Payment did not complete",Toast.LENGTH_LONG).show()
                        print(e.message)
                    }

                })
        )
    }
}