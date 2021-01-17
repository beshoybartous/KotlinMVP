package com.example.kotlinmvp.ui.movie_detail

import com.example.kotlinmvp.base.BaseView


interface MovieDetailView: BaseView {
    fun isInserted(success: Boolean)
    fun isDeleted(success: Boolean)
}