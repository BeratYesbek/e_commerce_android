package com.beratyesbek.e_commerce_android.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.beratyesbek.e_commerce_android.R
import com.beratyesbek.e_commerce_android.databinding.CustomCartSummaryItemBinding
import com.beratyesbek.e_commerce_android.models.dtos.CartSummaryDto
import com.beratyesbek.e_commerce_android.utilities.IOnClickLister

class CartSummaryViewAdapter(private val cartSummaryDtoList: List<CartSummaryDto>,private val onclickListener : IOnClickLister<CartSummaryDto>) :
    RecyclerView.Adapter<CartSummaryViewAdapter.CartSummaryViewHolder>() {
    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartSummaryViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = DataBindingUtil.inflate<CustomCartSummaryItemBinding>(
            inflater,
            R.layout.custom_cart_summary_item,
            parent,
            false
        )
        return CartSummaryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartSummaryViewHolder, position: Int) {
        holder.view.cartSummaryDto = cartSummaryDtoList[position]

        holder.view.btnRemoveProduct.setOnClickListener {
            onclickListener.onClickListener(cartSummaryDtoList[position])
        }
    }

    override fun getItemCount(): Int {
        return cartSummaryDtoList.size
    }

    class CartSummaryViewHolder(var view: CustomCartSummaryItemBinding) :
        RecyclerView.ViewHolder(view.root)


}