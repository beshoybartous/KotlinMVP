package com.example.kotlinmvp.ui.movies.popular_movies

import com.example.kotlinmvp.base.BaseView
import com.example.kotlinmvp.model.response.MovieResponse

interface PopularMoviesView : BaseView {

    fun getMovies(movieResponse: MovieResponse)
    fun isInserted(id:Int)
    fun isDeleted(id:Int)

}