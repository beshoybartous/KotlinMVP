package com.example.kotlinmvp.ui.movies.favourite_movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvp.R
import com.example.kotlinmvp.databinding.ItemMovieBinding
import com.example.kotlinmvp.model.MovieModel


class FavouriteMoviesAdapter() : RecyclerView.Adapter<FavouriteMoviesAdapter.MovieViewHolder>() {

    var moviesList = listOf<MovieModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(moviesList[position])
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }


    class MovieViewHolder(private var binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieModel) {

            binding.btnFavourite.setImageResource(R.drawable.ic_favorite)

//            Picasso.get().load(movie.getPoster)
//                .into(binding.ivMoviePoster)
            // Pixel.load(movie.getPoster,  PixelOptions.Builder().setPlaceholderResource(R.drawable.ic_loading_android).build(),binding.ivMoviePoster)

            binding.tvMovieTitle.text = (movie.title)
            binding.tvReleaseDate.text = (movie.releaseDate)
            binding.rbRating.rating = (movie.voteAverage.toFloat()) / 2
        }

    }
}