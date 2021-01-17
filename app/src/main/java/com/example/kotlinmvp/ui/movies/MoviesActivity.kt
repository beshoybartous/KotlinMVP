package com.example.kotlinmvp.ui.movies

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.kotlinmvp.R
import com.example.kotlinmvp.base.AnyPresenter
import com.example.kotlinmvp.base.BaseActivity
import com.example.kotlinmvp.base.BaseView
import com.example.kotlinmvp.databinding.ActivityMainBinding

class MoviesActivity : BaseActivity<ActivityMainBinding, AnyPresenter>(), BaseView {

    lateinit var moviesIDList: ArrayList<Int>

    companion object {
        private const val KEY_MOVIE_ID_LIST = "movies id"

        @JvmStatic
        fun startMoviesActivity(context: Context, moviesIdList: List<Int>) {
            val moviesActivityIntent = Intent(context, MoviesActivity::class.java)
            moviesActivityIntent.putIntegerArrayListExtra(
                KEY_MOVIE_ID_LIST,
                moviesIdList as ArrayList<Int?>?
            )
            context.startActivity(moviesActivityIntent)
        }
    }

    override fun initBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initPresenter(): AnyPresenter {
        return AnyPresenter(this)
    }

    override fun onActivityCreated() {
//     intent.getSerializableExtra(KEY_MOVIE_ID_LIST)?.let{
//         moviesIDList = intent.getIntegerArrayListExtra(KEY_MOVIE_ID_LIST)!!
//     }
//
        val navController = Navigation.findNavController(this, R.id.myNavHostFragment)
        NavigationUI.setupWithNavController(binding.bottomNav, navController)
        binding.bottomNav.background = null
        binding.bottomNav.menu.getItem(1).isEnabled = false
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (
                destination.id == R.id.popular_movie_fragment ||
                destination.id == R.id.top_rated_movie_fragment
            ) {
                binding.fabHome.backgroundTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.colorAccent))
            } else {
                binding.fabHome.backgroundTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.colorPrimary))
            }
        }

        binding.fabHome.setOnClickListener {
            navController.navigateUp()
            navController.navigate(R.id.favourite_movies_fragment)
        }
    }
}