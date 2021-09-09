package com.beratyesbek.e_commerce_android.adapters

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.beratyesbek.e_commerce_android.R
import com.beratyesbek.e_commerce_android.databinding.CustomProductItemBinding
import com.beratyesbek.e_commerce_android.models.dtos.ProductDto
import com.beratyesbek.e_commerce_android.utilities.IOnClickLister

class ProductsViewAdapter(private val products : ArrayList<ProductDto>,private val onClickListener : IOnClickLister<ProductDto>) : RecyclerView.Adapter<ProductsViewAdapter.ProductsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val view = DataBindingUtil.inflate<CustomProductItemBinding>(inflater,R.layout.custom_product_item,parent,false)
        return  ProductsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val productDto = products[position]
        holder.view.productDto = productDto

        holder.view.btnAddCartSummary.setOnClickListener {
            onClickListener.onClickListener(productDto)
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }

   inner class ProductsViewHolder(var view :CustomProductItemBinding) : RecyclerView.ViewHolder(view.root) {

    }


}