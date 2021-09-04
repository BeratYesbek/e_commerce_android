package com.beratyesbek.e_commerce_android.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.beratyesbek.e_commerce_android.R

class ProductsViewAdapter(private val products : Array<String>) : RecyclerView.Adapter<ProductsViewAdapter.ProductsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.custom_product_item,parent,false);
        return  ProductsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        print(products[position])
    }

    override fun getItemCount(): Int {
        return products.size
    }

   inner class ProductsViewHolder(view :View) : RecyclerView.ViewHolder(view) {

    }


}