package com.example.kotlinmvp.base

interface ItemClickListener<T> {

    fun onItemClicked(model: T, action: Int = 0)
}