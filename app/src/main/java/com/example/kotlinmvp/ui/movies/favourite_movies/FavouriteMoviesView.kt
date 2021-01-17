package com.example.kotlinmvp.ui.movies.favourite_movies

import com.example.kotlinmvp.base.BaseView
import com.example.kotlinmvp.model.MovieModel

interface FavouriteMoviesView : BaseView {
    fun getMovies(movies: List<MovieModel>)
    fun isDeleted(id: Int?)
}