package com.example.kotlinmvp.ui.movies.favourite_movies

import com.example.kotlinmvp.base.BasePresenter
import com.example.kotlinmvp.model.MovieModel
import kotlinx.coroutines.Dispatchers

class FavouriteMoviesPresenter(override val view: FavouriteMoviesView) : BasePresenter(view) {
    fun getFavouriteMovies(){

//        coroutineScope.launch {
//            val result = withContext(Dispatchers.IO) {
//                 database.movieDao().getMovies()
//
//            }
//            result?.let {
//                val movieModelList= mutableListOf<MovieModel>()
//                for (movie in it) {
//                    movieModelList.add(movie.toModel)
//                }
//                view.getMovies(movieModelList)
//            }
//
//        }
    }
//
//    fun deleteData(movie: MovieModel){
//        coroutineScope.launch {
//            val result= withContext(Dispatchers.IO) {
//                database.movieDao().delete(movie.toEntity)
//            }
//            if(result==0){
//                view.isDeleted(-1)
//            }
//            else{
//                view.isDeleted(movie.id!!)
//            }
//        }
//    }
}