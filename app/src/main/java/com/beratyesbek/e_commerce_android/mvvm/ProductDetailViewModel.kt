package com.beratyesbek.e_commerce_android.mvvm

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.beratyesbek.e_commerce_android.models.CartSummary
import com.beratyesbek.e_commerce_android.models.dtos.ProductDto
import com.beratyesbek.e_commerce_android.services.cartSummaryService.CartSummaryService
import com.beratyesbek.e_commerce_android.services.cartSummaryService.ICartSummaryService
import com.beratyesbek.e_commerce_android.services.productService.IProductService
import com.beratyesbek.e_commerce_android.services.productService.ProductService
import com.beratyesbek.e_commerce_android.utilities.response.ResponseModel
import com.beratyesbek.e_commerce_android.utilities.response.SingleResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    application: Application,
    private val productService: IProductService,
    private val cartSummaryService: ICartSummaryService
) : BaseViewModel(application),
    CoroutineScope {

    val productDto = MutableLiveData<ProductDto>()

    private val disposable = CompositeDisposable()


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
                    }

                    override fun onError(e: Throwable) {
                        print(e.message)
                    }

                })
        )
    }

    fun getProductDtoById(id: Number) {
        disposable.add(
            productService.getProductDetailById(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :
                    DisposableSingleObserver<SingleResponseModel<ProductDto>>() {
                    override fun onSuccess(t: SingleResponseModel<ProductDto>) {
                        if (t.success) {
                            productDto.value = t.data!!
                        }
                    }

                    override fun onError(e: Throwable) {
                        print(e.message)
                    }
                })
        )
    }

}