package com.example.kotlinmvp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvp.base.ItemClickListener
import com.example.kotlinmvp.databinding.ItemMovieBinding
import com.example.kotlinmvp.model.MovieModel
import com.example.kotlinmvp.model.getPoster
import com.squareup.picasso.Picasso


public class MoviesAdapter(private val itemClickListener: ItemClickListener<MovieModel>) :
    RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {
     var movieList = mutableListOf<MovieModel>()
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
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun updateList(movieList: List<MovieModel>) {
        this.movieList = (this.movieList + movieList)as MutableList<MovieModel>
        notifyItemInserted(this.movieList.size)
    }
//    fun remove(id:Int){
//        for (movie in moviesList){
//            movie.id?.equals(id)?.let {
//                moviesList.remove(movie)
//                notifyDataSetChanged()
//                return
//            }
//        }
//    }

    inner class MovieViewHolder(private var binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var isInDatabase = false

        fun bind(movie: MovieModel ) {
//            isInDatabase = SharedPref.contain(movie.id!!)
//            Log.d("isIndatabase", "bind: ${SharedPref.moviesIDMap.size}")
//            if (isInDatabase) {
//                binding.btnFavourite.setImageResource(R.drawable.ic_favorite)
//            } else {
//                binding.btnFavourite.setImageResource(R.drawable.ic_not_favourite)
//            }
//            binding.btnFavourite.setOnClickListener {
//                if (!isInDatabase) {
//                    movieClickListener.addToFavourite(movie)
//                } else {
//                    movieClickListener.removeFromFavourite(movie)
//                }
//            }
            binding.root.setOnClickListener {
                itemClickListener.onItemClicked(movie)
            }
//
//
            Picasso.get().load(movie.getPoster)
                .into(binding.ivMoviePoster)
////            Pixel.load(movie.getPoster, PixelOptions.Builder().setPlaceholderResource(R.drawable.ic_loading_android).build(),binding.ivMoviePoster)
//
            binding.tvMovieTitle.text = (movie.title)
            binding.tvReleaseDate.text = (movie.releaseDate)
            binding.rbRating.rating = (movie.voteAverage.toFloat()) / 2
            binding.btnFavourite.setOnClickListener {
                itemClickListener.onItemClicked(model = movie,action = 1)
            }
        }

    }
}

interface MovieClickListener {
    fun onCLick(movie: MovieModel?)
    fun addToFavourite(movie: MovieModel?)
    fun removeFromFavourite(model: MovieModel?)
}