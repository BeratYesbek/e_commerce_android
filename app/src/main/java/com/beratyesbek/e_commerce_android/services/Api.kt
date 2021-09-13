package com.beratyesbek.e_commerce_android.services

import com.beratyesbek.e_commerce_android.models.IEntity
import com.beratyesbek.e_commerce_android.models.Product
import com.beratyesbek.e_commerce_android.services.productService.IProductService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

open class Api {
    companion object {
        val BASE_URL = "https://68e3-88-226-106-44.ngrok.io/api/"
        // S is a service T is a model
        // for example url = https://localhost:44303/api/products or categories or students
        inline fun <reified S, reified T : IEntity> api(): S {
            var baseUrl = "https://68e3-88-226-106-44.ngrok.io/api/"

            //When we send request to API must put the model name, but some model name might end with 'y' character.
            // we always use plural name in API that's way if it was ended with 'y' character we need to remove 'y' and we need to put 'ies' end of the model name
            if (T::class.java.simpleName.last() != 'y') {
                baseUrl += "${T::class.java.simpleName}s/"
            } else {
                val length = T::class.java.simpleName.length
                val modelName = T::class.java.simpleName.substring(0, length - 1)
                baseUrl += "${modelName}ies/"
            }
            return Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(S::class.java)
        }
    }
}
