package com.example.kotlinmvp.ui.movies.top_rated_movies

import com.example.kotlinmvp.base.BaseView
import com.example.kotlinmvp.model.response.MovieResponse

interface TopRatedMoviesView : BaseView {

    fun getMovies(movieResponse: MovieResponse)
    fun isInserted(success: Boolean)
    fun isDeleted(id: Int)
}