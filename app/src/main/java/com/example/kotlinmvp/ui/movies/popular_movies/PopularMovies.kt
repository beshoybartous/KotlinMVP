package com.example.kotlinmvp.ui.movies.popular_movies

import com.example.kotlinmvp.base.BaseFragment
import com.example.kotlinmvp.databinding.FragmentPopularMoviesBinding
import com.example.kotlinmvp.model.MovieModel
import com.example.kotlinmvp.model.response.MovieResponse
import com.example.kotlinmvp.ui.adapter.MovieClickListener
import com.example.kotlinmvp.ui.adapter.MoviesAdapter
import com.example.kotlinmvp.ui.movie_detail.MovieDetail
import com.example.kotlinmvp.ui.movies.popular_movies.PopularMoviesPresenter
import com.example.kotlinmvp.ui.movies.popular_movies.PopularMoviesView

class PopularMovies : BaseFragment<FragmentPopularMoviesBinding, PopularMoviesPresenter>(),
    PopularMoviesView, MovieClickListener {
    lateinit var adapter: MoviesAdapter
    var pageCounter = 1
    var isLoading = true
    var totalNumberOfPages = 0
    override fun initBinding(): FragmentPopularMoviesBinding {
        return FragmentPopularMoviesBinding.inflate(layoutInflater)
    }

    override fun initPresenter(): PopularMoviesPresenter {
        return PopularMoviesPresenter(this)
    }

    override fun onFragmentCreated() {
//        adapter = MoviesAdapter(this)
//        viewBinding.rvPopularMovies.adapter = adapter
//        presenter.getData(MoviePayLoad(EndPoints.API_KEY, pageCounter))
//
//        viewBinding.rvPopularMovies.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//                val lastVisibleItemPosition =
//                    (recyclerView.layoutManager as LinearLayoutManager?)!!.findLastCompletelyVisibleItemPosition()
//                val listSize = (recyclerView.layoutManager as LinearLayoutManager?)!!.itemCount - 2
//                if (lastVisibleItemPosition >= listSize && isLoading && pageCounter < totalNumberOfPages) {
//                    isLoading = false
//                    pageCounter++
//                    val moviesPayLoad2 = MoviePayLoad(EndPoints.API_KEY, pageCounter)
//                    presenter.getData(moviesPayLoad2)
//                }
//            }
//        })
    }
//
//    override fun onStart() {
//        super.onStart()
//        EventBus.getDefault().register(this)
//    }

//    override fun onStop() {
//        super.onStop()
//        EventBus.getDefault().unregister(this)
//    }

//    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
//    fun eventData(movieEvent: MovieEvent?) {
//        adapter.notifyDataSetChanged()
//    }

    override fun getMovies(movieResponse: MovieResponse) {
//        totalNumberOfPages = movieResponse.totalPages!!
//        movieResponse.results?.let {
//            if (it.isNotEmpty()) {
//                adapter.updateList(movieResponse.results)
//                isLoading = true
//            }
//        }
    }

    override fun isInserted(id: Int) {
//        SharedPref.addValue(id)
//        Log.d("isIndatabase", "bind: ${SharedPref.moviesIDMap.size}")
//
//        adapter.notifyDataSetChanged()
    }

    override fun isDeleted(id: Int) {
//        if(id!=-1) {
//            SharedPref.removeValue(id)
//            adapter.notifyDataSetChanged()
//        }
    }

    override fun onCLick(movie: MovieModel?) {
        MovieDetail.startMovieDetailActivity(requireContext(), movie!!)

//        SharedPref.removeValue(id)
//        adapter.notifyDataSetChanged()
    }

    override fun addToFavourite(movie: MovieModel?) {
//        movie?.let {
//            presenter.insertData(movie)
//        }
    }

    override fun removeFromFavourite(model: MovieModel?) {
//        model?.let {
//            presenter.deleteData(model)
//        }
    }
}