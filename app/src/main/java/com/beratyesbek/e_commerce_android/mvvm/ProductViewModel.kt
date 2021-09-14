package com.beratyesbek.e_commerce_android.mvvm

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.beratyesbek.e_commerce_android.models.CartSummary
import com.beratyesbek.e_commerce_android.models.dtos.ProductDto
import com.beratyesbek.e_commerce_android.services.cartSummaryService.CartSummaryService
import com.beratyesbek.e_commerce_android.services.productService.ProductManager
import com.beratyesbek.e_commerce_android.utilities.response.ListResponseModel
import com.beratyesbek.e_commerce_android.utilities.response.ResponseModel
import com.beratyesbek.e_commerce_android.utilities.sharedPreferences.CustomSharedPreferences
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

open class ProductViewModel(application: Application) : BaseViewModel(application) {

    val productDtoList = MutableLiveData<List<ProductDto>>()
    val cartSummaryList = MutableLiveData<List<CartSummary>>()
    private val productManager = ProductManager()
    private val cartSummaryService = CartSummaryService()
    private val disposable = CompositeDisposable()
    private val customSharedPreferences = CustomSharedPreferences(application)

    fun addCartSummary(cartSummary: CartSummary) {
        disposable.add(
            cartSummaryService.add(cartSummary)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<ResponseModel>() {
                    override fun onSuccess(t: ResponseModel) {
                        Toast.makeText(
                            getApplication(),
                            "Product has been added into cart",
                            Toast.LENGTH_LONG
                        ).show()
                        getCartSummaryByUserId()
                    }

                    override fun onError(e: Throwable) {
                        print(e.message)
                    }

                })
        )
    }

    fun getCartSummaryByUserId() {
        disposable.add(
            cartSummaryService.getAllByUserId(1)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<ListResponseModel<CartSummary>>() {
                    override fun onSuccess(t: ListResponseModel<CartSummary>) {
                        if (t.success) {
                            cartSummaryList.value = t.data!!
                        }
                    }

                    override fun onError(e: Throwable) {
                        print(e.message)
                    }

                })
        )
    }

    fun getAllProductDetail() {
        disposable.add(
            productManager.getAllProductDetail()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<ListResponseModel<ProductDto>>() {
                    override fun onSuccess(t: ListResponseModel<ProductDto>) {
                        if (t.success) {
                            productDtoList.value = t.data!!
                        }
                    }

                    override fun onError(e: Throwable) {
                        print(e.message)
                    }

                })
        )
    }

    fun removeToken() {
        customSharedPreferences.removeToken()
    }

}