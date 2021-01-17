package com.example.kotlinmvp.ui.movies.top_rated_movies

import com.example.kotlinmvp.base.BasePresenter
import com.example.kotlinmvp.cache.database.AppDatabase
import com.example.kotlinmvp.model.MovieModel
import com.example.kotlinmvp.model.payload.MoviePayLoad
import com.example.kotlinmvp.model.payload.toMap
import com.example.kotlinmvp.model.response.MovieResponse
import com.example.kotlinmvp.model.toEntity
import com.example.kotlinmvp.network.Endpoints
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TopRatedMoviesPresenter(override val view: TopRatedMoviesView) :
    BasePresenter(view) {
    fun getData(parameter: MoviePayLoad) {
        view.showLoading()
        coroutineScope.launchCatching(
            block = {
                val result=networkManager?.getRequest(
                    api = Endpoints.POPULAR_MOVIES,
                    param = parameter.toMap as Map<String, Any>,
                    parseClass = MovieResponse::class.java
                )
                result?.let {
                    view.hideLoading()
                    view.getMovies(it)
                }
            },
            onError = {
                view.hideLoading()
                handleError(it)
            }
        )
    }
    fun insertData(movie: MovieModel){
        view.showLoading()
        coroutineScope.launchCatching(
            block = {
                AppDatabase.DatabaseBuilder.getInstance().movieDao().insert(movie.toEntity)
                view.isInserted(true)
                view.hideLoading()
            }, onError = ::handleError
        )
    }
    //fun insertData(movie: MovieModel) {
//        coroutineScope.launch {
//            val result = withContext(Dispatchers.IO) {
//                  database.movieDao().insert(movie.toEntity)
//
//            }
//            if(result.toInt()!=-1){
//                view.isInserted(result.toInt())
//            }
//
//        }
  //  }

    fun deleteData(movie: MovieModel) {
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
    }
}