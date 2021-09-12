package com.beratyesbek.e_commerce_android.adapters

import android.content.Context
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.beratyesbek.e_commerce_android.R
import com.beratyesbek.e_commerce_android.activities.ProductActivity
import com.beratyesbek.e_commerce_android.databinding.CustomProductItemBinding
import com.beratyesbek.e_commerce_android.fragments.ProductDetailFragment
import com.beratyesbek.e_commerce_android.models.dtos.ProductDto
import com.beratyesbek.e_commerce_android.utilities.IOnClickLister

class ProductsViewAdapter(private val products : ArrayList<ProductDto>,
                          private val onClickListener : IOnClickLister<ProductDto>)
    : RecyclerView.Adapter<ProductsViewAdapter.ProductsViewHolder>() {
    private lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        context = parent.context
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

        holder.view.btnSeeDetail.setOnClickListener {
            seeDetail(productDto)
        }
    }

    private fun seeDetail(productDto : ProductDto){
        val transaction: FragmentTransaction = (context as ProductActivity).supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.fade_in_anim,R.anim.fade_out_anim)
        transaction.replace(R.id.frameLayout_product_activity,ProductDetailFragment(productDto,context as ProductActivity))
        transaction.commit()
    }

    override fun getItemCount(): Int {
        return products.size
    }

   inner class ProductsViewHolder(var view :CustomProductItemBinding) : RecyclerView.ViewHolder(view.root) {

    }


}