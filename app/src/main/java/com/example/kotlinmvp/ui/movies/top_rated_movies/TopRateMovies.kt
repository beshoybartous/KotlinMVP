package com.example.kotlinmvp.ui.movies.top_rated_movies

import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvp.base.BaseFragment
import com.example.kotlinmvp.base.ItemClickListener
import com.example.kotlinmvp.databinding.FragmentTopRatedMoviesBinding
import com.example.kotlinmvp.model.EmployeeModel
import com.example.kotlinmvp.model.MovieModel
import com.example.kotlinmvp.model.payload.MoviePayLoad
import com.example.kotlinmvp.model.response.MovieResponse
import com.example.kotlinmvp.network.Endpoints
import com.example.kotlinmvp.ui.adapter.MoviesAdapter
import com.example.kotlinmvp.ui.bottom_sheet.EmployeeInfoBottomSheet
import com.example.kotlinmvp.ui.bottom_sheet.MovieInfoBottomSheet
import com.example.kotlinmvp.ui.movie_detail.MovieDetail

class TopRateMovies : BaseFragment<FragmentTopRatedMoviesBinding, TopRatedMoviesPresenter>(),
    TopRatedMoviesView {
    lateinit var adapter: MoviesAdapter
    var pageCounter = 1
    var isLoading = true
    var totalNumberOfPages = 0
    override fun initBinding(): FragmentTopRatedMoviesBinding {
        return FragmentTopRatedMoviesBinding.inflate(layoutInflater)
    }

    override fun initPresenter(): TopRatedMoviesPresenter {
        return TopRatedMoviesPresenter(this)
    }

    override fun onFragmentCreated() {
        adapter = MoviesAdapter(object : ItemClickListener<MovieModel> {
            override fun onItemClicked(model: MovieModel, action: Int) {
                if (action == 0)
                    model.let {
                        MovieDetail.startMovieDetailActivity(requireContext(), it)
                    }
                else
                {
                    model.let {movie->
                        val movieInfoBottomSheet =
                            MovieInfoBottomSheet(movie, object : ItemClickListener<MovieModel> {
                                override fun onItemClicked(model: MovieModel, action: Int) {
                                    model.id?.let { presenter.insertData(movie) }
                                }
                            })
                        if (!movieInfoBottomSheet.isAdded)
                            movieInfoBottomSheet.show((activity as FragmentActivity).supportFragmentManager, movieInfoBottomSheet.tag)
                    }
                }
            }
        })
        binding.rvTopRatedMovies.adapter = adapter
        presenter.getData(MoviePayLoad(Endpoints.API_KEY, pageCounter))
//
        binding.rvTopRatedMovies.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val lastVisibleItemPosition =
                    (recyclerView.layoutManager as LinearLayoutManager?)!!.findLastCompletelyVisibleItemPosition()
                val listSize = (recyclerView.layoutManager as LinearLayoutManager?)!!.itemCount - 2
                if (lastVisibleItemPosition >= listSize && isLoading && pageCounter < totalNumberOfPages) {
                    isLoading = false
                    pageCounter++
                    val moviesPayLoad2 = MoviePayLoad(Endpoints.API_KEY, pageCounter)
                    presenter.getData(moviesPayLoad2)
                }
            }
        })
    }

//    override fun onStart() {
//        super.onStart()
//        EventBus.getDefault().register(this)
//    }
//
//    override fun onStop() {
//        super.onStop()
//        EventBus.getDefault().unregister(this)
//    }
//
//    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
//    fun eventData(movieEvent: MovieEvent?) {
//        adapter.notifyDataSetChanged()
//    }

    override fun getMovies(movieResponse: MovieResponse) {
        totalNumberOfPages = movieResponse.totalPages!!
        movieResponse.results?.let {
            if (it.isNotEmpty()) {
                adapter.updateList(movieResponse.results)
                isLoading = true
            }
        }
    }

    override fun isInserted(id: Boolean) {
        Toast.makeText(context,"added",Toast.LENGTH_LONG)
    }

    override fun isDeleted(id: Int) {
//        SharedPref.removeValue(id)
//        adapter.notifyDataSetChanged()
    }

//    override fun onCLick(movie: MovieModel?) {
//        MovieDetail.startMovieDetailActivity(requireContext(), movie!!)
//    }
//
//    override fun addToFavourite(movie: MovieModel?) {
////        movie?.let {
////            presenter.insertData(movie)
////        }
//    }
//
//    override fun removeFromFavourite(model: MovieModel?) {
////        model?.let {
////            presenter.deleteData(model)
////        }
//    }
}