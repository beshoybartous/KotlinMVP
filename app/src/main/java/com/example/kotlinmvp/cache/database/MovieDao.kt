package com.example.kotlinmvp.cache.database

import androidx.room.*
import com.example.kotlinmvp.model.entity.MovieEntity

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movieEntity: MovieEntity):Long

    @Delete
    suspend fun delete(movieEntity: MovieEntity):Int

    @Query("Select id from movies where id= :id")
    suspend fun getSpecificMovie(id: Int): Int

    @Query("SELECT EXISTS(SELECT * FROM movies WHERE id = :id)")
    suspend fun isMovieExist(id: Int): Boolean

    @Query("Select id from movies")
    suspend fun getMoviesId(): List<Int>?

    @Query("Select * from movies")
    suspend fun getMovies(): List<MovieEntity>?
}