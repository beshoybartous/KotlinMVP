package com.example.kotlinmvp.ui.movie_detail

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.example.kotlinmvp.R
import com.example.kotlinmvp.base.BaseActivity
import com.example.kotlinmvp.cache.shared_pref.SharedPref
import com.example.kotlinmvp.databinding.ActivityDetailBinding
import com.example.kotlinmvp.model.MovieModel
import com.example.kotlinmvp.model.getPoster
import com.example.moviesappmvpkotlin.ui.movie_detail.MovieDetailPresenter
import com.squareup.picasso.Picasso
import org.greenrobot.eventbus.EventBus

class MovieDetail : BaseActivity<ActivityDetailBinding, MovieDetailPresenter>(), MovieDetailView {
    private var isInDatabase = false
    lateinit var movieModel: MovieModel

    companion object {
        private const val KEY_MOVIE_DETAIL = "movie detail"

        @JvmStatic
        fun startMovieDetailActivity(context: Context, movie: MovieModel) {
            val moviesDetailActivityIntent = Intent(context, MovieDetail::class.java)
            moviesDetailActivityIntent.putExtra(
                KEY_MOVIE_DETAIL,
                movie
            )
            context.startActivity(moviesDetailActivityIntent)
        }
    }

    override fun initBinding(): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun initPresenter(): MovieDetailPresenter {
        return MovieDetailPresenter(this)
    }

    override fun onActivityCreated() {
        intent.getParcelableExtra<MovieModel>(KEY_MOVIE_DETAIL)?.let {
            movieModel = intent.getParcelableExtra(KEY_MOVIE_DETAIL)!!
            presenter.movieExist(movieModel.id!!)
            binding.tvMovieTitle.text = movieModel.title
            binding.tvOverview.text = movieModel.overView
            binding.tvReleaseDate.text = movieModel.releaseDate
            binding.rbRating.rating = movieModel.voteAverage.toFloat()
//            Pixel.load(movieModel.getPoster,  PixelOptions.Builder().setPlaceholderResource(R.drawable.ic_loading_android).build(),viewBinding.ivMoviePoster)

            Picasso.get().load(movieModel.getPoster).into(binding.ivMoviePoster)
//            if (SharedPref.contain(movieModel.id!!)) {
//                viewBinding.fabFavourite.setImageResource(R.drawable.ic_favorite)
//                isInDatabase = true
//            }
            binding.fabFavourite.setOnClickListener {
                if (!isInDatabase) {
                    presenter.insertData(movieModel)
                } else {
                    presenter.deleteData(movieModel)
                }
            }
        }
    }

    override fun isInserted(success: Boolean) {
        if (success) {
            isInDatabase = true
            binding.fabFavourite.setImageResource(R.drawable.ic_favorite)

        } else {
            isInDatabase = false
            binding.fabFavourite.setImageResource(R.drawable.ic_not_favourite)
        }
    }

    override fun isDeleted(success: Boolean) {
//        if (success) {
//            isInDatabase = false
//            viewBinding.fabFavourite.setImageResource(R.drawable.ic_not_favourite)
//            SharedPref.removeValue(movieModel.id!!)
//            EventBus.getDefault().postSticky(MovieEvent())
//        } else {
//            Toast.makeText(this, "Failed to delete from database", Toast.LENGTH_SHORT).show()
//        }
    }


}