package com.beratyesbek.e_commerce_android.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.beratyesbek.e_commerce_android.R
import com.beratyesbek.e_commerce_android.adapters.ProductsViewAdapter
import com.beratyesbek.e_commerce_android.databinding.ActivityProductBinding
import com.beratyesbek.e_commerce_android.models.CartSummary
import com.beratyesbek.e_commerce_android.models.Product
import com.beratyesbek.e_commerce_android.models.dtos.ProductDto
import com.beratyesbek.e_commerce_android.mvvm.ProductViewModel
import com.beratyesbek.e_commerce_android.utilities.IOnClickLister
import com.beratyesbek.e_commerce_android.utilities.OnPassData

class ProductActivity : AppCompatActivity(), IOnClickLister<ProductDto>, OnPassData<CartSummary> {

    private lateinit var dataBinding: ActivityProductBinding
    private lateinit var productsViewAdapter: ProductsViewAdapter
    private val viewModel: ProductViewModel by viewModels()
    private val productList = ArrayList<ProductDto>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = ActivityProductBinding.inflate(layoutInflater)
        val view = dataBinding.root
        setContentView(view)

        setSupportActionBar(dataBinding.toolbar.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        runRecyclerView()
        viewModel.getAllProductDetail()
        viewModel.getCartSummaryByUserId()

        viewModel.cartSummaryList.observe(this, { cartSummaryList ->
            dataBinding.toolbar.textViewCartSummaryCount.text = cartSummaryList.size.toString()
        })


        viewModel.productDtoList.observe(this, { productDtoList ->
            productList.addAll(productDtoList)
            productsViewAdapter.notifyDataSetChanged()

        })

        dataBinding.toolbar.btnCartSummary.setOnClickListener {
            val intentToCartSummaryActivity = Intent(this, CartSummaryActivity::class.java)
            startActivity(intentToCartSummaryActivity)
        }

    }

    override fun onResume() {
        super.onResume()
        viewModel.getCartSummaryByUserId()
    }

    private fun addToCartSummary(cartSummary: CartSummary) {
        viewModel.addCartSummary(cartSummary)
    }

    private fun runRecyclerView() {
        val layoutManager = LinearLayoutManager(this);
        dataBinding.recyclerViewProductActivity.layoutManager = layoutManager;
        productsViewAdapter = ProductsViewAdapter(productList, this)
        dataBinding.recyclerViewProductActivity.adapter = productsViewAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> {
                viewModel.removeToken()
                val intentToLoginActivity = Intent(this, LoginActivity::class.java)
                startActivity(intentToLoginActivity)
                finish()
            }
        }
        return true
    }

    override fun onClickListener(value: ProductDto) {
        addToCartSummary(CartSummary(null, value.productId, 1))
    }

    override fun onLongClickLister(value: ProductDto) {
        TODO("Not yet implemented")
    }

    override fun onPassData(value: CartSummary) {
        viewModel.addCartSummary(value)
    }
}