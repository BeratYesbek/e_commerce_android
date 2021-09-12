package com.beratyesbek.e_commerce_android.mvvm

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.beratyesbek.e_commerce_android.models.CartSummary
import com.beratyesbek.e_commerce_android.models.dtos.CartSummaryDto
import com.beratyesbek.e_commerce_android.services.cartSummaryService.CartSummaryService
import com.beratyesbek.e_commerce_android.utilities.response.ListResponseModel
import com.beratyesbek.e_commerce_android.utilities.response.ResponseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope

class CartSummaryViewModel(application: Application) : BaseViewModel(application), CoroutineScope {

    val cartSummaryDtoList = MutableLiveData<List<CartSummaryDto>>()
    private val disposable = CompositeDisposable()
    private val cartSummaryService = CartSummaryService()

    fun getCartSummaryById(id: Number) {
        disposable.add(
            cartSummaryService.getCartSummaryDetailByUserId(id).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :
                    DisposableSingleObserver<ListResponseModel<CartSummaryDto>>() {
                    override fun onSuccess(t: ListResponseModel<CartSummaryDto>) {
                        System.out.println("t.data?.size")
                        System.out.println(t.data?.size)
                        if (t.success) {
                            cartSummaryDtoList.value = t.data!!
                        }
                    }

                    override fun onError(e: Throwable) {
                        System.out.println("error " + e.message)
                    }

                })
        )
    }

    fun removeCartSummary(cartSummaryDto: CartSummaryDto){
        val cartSummary = CartSummary(cartSummaryDto.id,cartSummaryDto.productId,cartSummaryDto.userId)
        disposable.add(
            cartSummaryService.delete(cartSummary)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<ResponseModel>() {
                    override fun onSuccess(t: ResponseModel) {
                       if (t.success){
                           Toast.makeText(getApplication(),"${cartSummaryDto.product.productName} has been removed",Toast.LENGTH_LONG).show()
                       }
                    }

                    override fun onError(e: Throwable) {
                        print(e.message)
                    }

                })
        )
    }
}