package com.beratyesbek.e_commerce_android.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.beratyesbek.e_commerce_android.R
import com.beratyesbek.e_commerce_android.adapters.CartSummaryViewAdapter
import com.beratyesbek.e_commerce_android.databinding.ActivityCartSummaryBinding
import com.beratyesbek.e_commerce_android.models.dtos.CartSummaryDto
import com.beratyesbek.e_commerce_android.mvvm.CartSummaryViewModel
import com.beratyesbek.e_commerce_android.utilities.IOnClickLister

class CartSummaryActivity : AppCompatActivity(),IOnClickLister<CartSummaryDto>  {

    private lateinit var dataBinding: ActivityCartSummaryBinding
    private lateinit var cartSummaryViewAdapter: CartSummaryViewAdapter
    private val viewModel : CartSummaryViewModel by viewModels()
    private val cartSummaryDtoList = ArrayList<CartSummaryDto>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = ActivityCartSummaryBinding.inflate(layoutInflater)
        val view = dataBinding.root
        setContentView(view)

        runRecyclerView()
        viewModel.getCartSummaryById(1)
        viewModel.cartSummaryDtoList.observe(this,{
            cartSummaryDtoList.clear()
            cartSummaryDtoList.addAll(it)
            calculateTotalPrice()
            cartSummaryViewAdapter.notifyDataSetChanged()
        })
        dataBinding.btnPayment.setOnClickListener {
            val intentToPaymentActivity  = Intent(this,PaymentActivity::class.java)
            startActivity(intentToPaymentActivity)
        }
    }

    private fun calculateTotalPrice(){
        var total = 0
        for (item in cartSummaryDtoList){
            total =+ item.product.productPrice!!
        }
        // tax %18
        dataBinding.textViewTotalPrice.text = "${(total * 18/100 + total)} $"
    }

    private fun runRecyclerView(){
        val layoutManager = LinearLayoutManager(this)
        dataBinding.recyclerViewCartSummaryActivity.layoutManager = layoutManager
        cartSummaryViewAdapter = CartSummaryViewAdapter(cartSummaryDtoList,this)
        dataBinding.recyclerViewCartSummaryActivity.adapter = cartSummaryViewAdapter
    }

    override fun onClickListener(value: CartSummaryDto) {
        viewModel.removeCartSummary(value)
        viewModel.getCartSummaryById(1)
    }

    override fun onLongClickLister(value: CartSummaryDto) {
        TODO("Not yet implemented")
    }
}