package com.beratyesbek.e_commerce_android.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.beratyesbek.e_commerce_android.adapters.ProductsViewAdapter
import com.beratyesbek.e_commerce_android.databinding.ActivityProductBinding
import com.beratyesbek.e_commerce_android.models.CartSummary
import com.beratyesbek.e_commerce_android.models.Product
import com.beratyesbek.e_commerce_android.models.dtos.ProductDto
import com.beratyesbek.e_commerce_android.mvvm.ProductViewModel
import com.beratyesbek.e_commerce_android.utilities.IOnClickLister

class ProductActivity : AppCompatActivity(),IOnClickLister<ProductDto> {

    private lateinit var dataBinding: ActivityProductBinding
    private lateinit var productsViewAdapter :ProductsViewAdapter
    private val viewModel : ProductViewModel by viewModels()
    private val productList = ArrayList<ProductDto>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = ActivityProductBinding.inflate(layoutInflater)
        val view = dataBinding.root
        setContentView(view)

        setSupportActionBar(dataBinding.toolbar.toolbar)


        runRecyclerView()
        viewModel.getAllProductDetail()
        viewModel.getCartSummaryByUserId()


        viewModel.cartSummaryList.observe(this,{ cartSummaryList ->
            dataBinding.toolbar.textViewCartSummaryCount.text = cartSummaryList.size.toString()
        })

        viewModel.productDtoList.observe(this,{ productDtoList ->
            productList.addAll(productDtoList)
            productsViewAdapter.notifyDataSetChanged()

        })
    }

    private fun addToCartSummary(cartSummary: CartSummary){
        viewModel.addCartSummary(cartSummary)
    }
    private fun runRecyclerView()  {
        val layoutManager = LinearLayoutManager(this);
        dataBinding.recyclerViewProductActivity.layoutManager = layoutManager;
        productsViewAdapter = ProductsViewAdapter(productList,this)
        dataBinding.recyclerViewProductActivity.adapter = productsViewAdapter

    }

    override fun onClickListener(value: ProductDto) {
        addToCartSummary(CartSummary(null,value.productId,1))
    }

    override fun onLongClickLister(value: ProductDto) {
        TODO("Not yet implemented")
    }
}