package com.example.kotlinmvp.ui.movies.popular_movies

import com.example.kotlinmvp.base.BasePresenter
import com.example.kotlinmvp.model.MovieModel
import com.example.kotlinmvp.model.payload.MoviePayLoad

class PopularMoviesPresenter(override val view: PopularMoviesView) :
    BasePresenter(view) {
    fun getData(parameter: MoviePayLoad) {
//        coroutineScope.launch {
//            val result = withContext(Dispatchers.IO) {
//                 networkManager.getData(
//                    EndPoints.POPULAR_MOVIES,
//                    parameter.toMap,
//                    MovieResponse::class.java
//                )
//
//            }
//            result?.let {
//                view.getMovies(it)
//            }
//        }
    }

    fun insertData(movie: MovieModel) {
//        coroutineScope.launch {
//            val result = withContext(Dispatchers.IO) {
//                 database.movieDao().insert(movie.toEntity)
//            }
//            Log.d("resultis", "insertData: $result")
//            if(result!=null &&  result.toInt()!=-1){
//                Log.d("resultis", "insertData: $result")
//
//                view.isInserted(result.toInt())
//            }
//
//        }
    }

    fun deleteData(movie: MovieModel) {
//        coroutineScope.launch {
//            val result = withContext(Dispatchers.IO) {
//                 database.movieDao().delete(movie.toEntity)
//
//            }
//            Log.d("deltesucc", "deleteData: $result")
//            if(result==0){
//                view.isDeleted(-1)
//            }
//            else{
//                view.isDeleted(movie.id!!)
//            }
//        }
    }
}