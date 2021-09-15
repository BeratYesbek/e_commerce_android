package com.beratyesbek.e_commerce_android.utilities.dependencyInjection

import com.beratyesbek.e_commerce_android.services.authService.AuthService
import com.beratyesbek.e_commerce_android.services.authService.IAuthService
import com.beratyesbek.e_commerce_android.services.cartSummaryService.CartSummaryService
import com.beratyesbek.e_commerce_android.services.cartSummaryService.ICartSummaryService
import com.beratyesbek.e_commerce_android.services.categoryService.CategoryService
import com.beratyesbek.e_commerce_android.services.categoryService.ICategoryService
import com.beratyesbek.e_commerce_android.services.paymentService.IPaymentService
import com.beratyesbek.e_commerce_android.services.paymentService.PaymentService
import com.beratyesbek.e_commerce_android.services.productService.IProductService
import com.beratyesbek.e_commerce_android.services.productService.ProductService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DependencyInjectionModule  {

    @Singleton
    @Provides
    fun cartSummaryServiceProvider() : ICartSummaryService{
        return CartSummaryService()
    }

    @Singleton
    @Provides
    fun categoryServiceProvider() : ICategoryService{
        return CategoryService()
    }


    @Singleton
    @Provides
    fun authServiceProvider() : IAuthService{
        return AuthService()
    }

    @Singleton
    @Provides
    fun productServiceProvider() : IProductService{
        return ProductService()
    }

    @Singleton
    @Provides
    fun paymentServiceProvider() : IPaymentService{
        return PaymentService()
    }
}