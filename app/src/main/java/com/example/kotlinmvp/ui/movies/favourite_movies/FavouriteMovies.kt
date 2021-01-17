package com.example.kotlinmvp.ui.movies.favourite_movies

import com.example.kotlinmvp.base.BaseFragment
import com.example.kotlinmvp.databinding.FragmentFavouriteMoviesBinding
import com.example.kotlinmvp.model.MovieModel
import com.example.kotlinmvp.ui.adapter.MovieClickListener
import com.example.kotlinmvp.ui.adapter.MoviesAdapter
import com.example.kotlinmvp.ui.movie_detail.MovieDetail


class FavouriteMovies : BaseFragment<FragmentFavouriteMoviesBinding, FavouriteMoviesPresenter>(),
    FavouriteMoviesView,
    MovieClickListener {

    lateinit var adapter: MoviesAdapter

    override fun initBinding(): FragmentFavouriteMoviesBinding {
        return FragmentFavouriteMoviesBinding.inflate(layoutInflater)
    }

    override fun initPresenter(): FavouriteMoviesPresenter {
        return FavouriteMoviesPresenter(this)
    }

    override fun onFragmentCreated() {
//        adapter = MoviesAdapter(this)
//        viewBinding.rvFavouriteMovies.adapter = adapter
//        presenter.getFavouriteMovies()
    }

//    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
//    fun eventData(moviesIdEvent: MovieEvent?) {
//        presenter.getFavouriteMovies()
//    }
//    override fun onStart() {
//        super.onStart()
//        EventBus.getDefault().register(this)
//    }

//    override fun onStop() {
//        super.onStop()
//        EventBus.getDefault().unregister(this)
//    }

    override fun getMovies(movies: List<MovieModel>) {
//        movies.let {
//            if(it.isNotEmpty()){
//                adapter.moviesList= it as MutableList<MovieModel>
//            }
//        }
    }

    override fun isDeleted(id: Int?) {
//        id?.let {
//            adapter.remove(id)
//            SharedPref.removeValue(id)
//        }
    }

    override fun onCLick(movie: MovieModel?) {
        MovieDetail.startMovieDetailActivity(requireContext(), movie!!)
    }

    override fun addToFavourite(movie: MovieModel?) {
        //("Not yet implemented")
    }

    override fun removeFromFavourite(model: MovieModel?) {
//        presenter.deleteData(model!!)
    }
}