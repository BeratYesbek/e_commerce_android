package com.beratyesbek.e_commerce_android.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.beratyesbek.e_commerce_android.R
import com.beratyesbek.e_commerce_android.adapters.ProductsViewAdapter
import com.beratyesbek.e_commerce_android.databinding.ActivityProductBinding

class ProductActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityProductBinding
    private lateinit var productsViewAdapter :ProductsViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = ActivityProductBinding.inflate(layoutInflater)
        val view = dataBinding.root
        setContentView(view)
        runRecyclerView()

    }

    private fun runRecyclerView()  {
        val arrayList = arrayOf<String>("","","","","")
        val layoutManager = LinearLayoutManager(this);
        dataBinding.recyclerViewProductActivity.layoutManager = layoutManager;
        productsViewAdapter = ProductsViewAdapter(arrayList)
        dataBinding.recyclerViewProductActivity.adapter = productsViewAdapter

        productsViewAdapter.notifyDataSetChanged()
    }
}