package com.beratyesbek.e_commerce_android.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import com.beratyesbek.e_commerce_android.R
import com.beratyesbek.e_commerce_android.databinding.FragmentProductDetailBinding
import com.beratyesbek.e_commerce_android.models.CartSummary
import com.beratyesbek.e_commerce_android.models.Comment
import com.beratyesbek.e_commerce_android.models.Product
import com.beratyesbek.e_commerce_android.models.dtos.ProductDto
import com.beratyesbek.e_commerce_android.mvvm.ProductDetailViewModel
import com.beratyesbek.e_commerce_android.utilities.OnPassData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailFragment(private val productDto : ProductDto,private val onPassData: OnPassData<CartSummary>) : Fragment() {
    private lateinit var dataBinding: FragmentProductDetailBinding
    private val viewModel : ProductDetailViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = FragmentProductDetailBinding.inflate(layoutInflater)
        val view = dataBinding.root

        getByProductId()

        dataBinding.btnAddToCart.setOnClickListener {
            addToCart()
        }

        return view
    }

    private fun addToCart(){
        val cartSummary = CartSummary(null,productDto.productId,1)
        onPassData.onPassData(cartSummary)

    }

    private fun getByProductId(){
        viewModel.getProductDtoById(productDto.productId)
        viewModel.productDto.observe(viewLifecycleOwner,{
            dataBinding.productDto = it
            calculateRating(it.comments)
        })
    }

    private fun calculateRating(comments : List<Comment>){
        var total :Number = 0
        for (comment in comments){
            total = comment.rating
        }
        dataBinding.imageViewProductRating.text = (total.toFloat()/comments.size).toString()
    }

}

