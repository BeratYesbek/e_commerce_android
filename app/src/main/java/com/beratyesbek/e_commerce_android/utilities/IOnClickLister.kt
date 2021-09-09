package com.beratyesbek.e_commerce_android.utilities

interface IOnClickLister<T> {
    fun onClickListener(value : T)
    fun onLongClickLister(value :T)
}