package com.example.moviesappmvpkotlin.ui.movie_detail

import android.content.Context
import android.util.Log
import com.example.kotlinmvp.base.BasePresenter
import com.example.kotlinmvp.cache.database.AppDatabase
import com.example.kotlinmvp.model.EmployeeModel
import com.example.kotlinmvp.model.MovieModel
import com.example.kotlinmvp.model.toEntity
import com.example.kotlinmvp.ui.movie_detail.MovieDetailView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieDetailPresenter(override val view: MovieDetailView): BasePresenter(view) {
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
    fun movieExist(id:Int){
        view.showLoading()
        coroutineScope.launchCatching(
            block = {
                val res=AppDatabase.DatabaseBuilder.getInstance().movieDao().isMovieExist(id)
                res.let {
                    if(it){
                        view.isInserted(it)
                    }
                    else{
                        view.isInserted(false)
                    }
                    view.hideLoading()
                }
            },
            onError = ::handleError
        )
    }
    fun deleteData(movie: MovieModel){
        view.showLoading()
        coroutineScope.launchCatching(
            block = {
               val res=AppDatabase.DatabaseBuilder.getInstance().movieDao().delete(movie.toEntity)
                view.isInserted(false)
                view.hideLoading()
            }, onError = ::handleError
        )
    }
}