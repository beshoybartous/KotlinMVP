package com.example.kotlinmvp.ui.bottom_sheet

import com.example.kotlinmvp.base.BaseBottomSheet
import com.example.kotlinmvp.base.ItemClickListener
import com.example.kotlinmvp.databinding.BottomSheetEmployeeInfoAyoutBinding
import com.example.kotlinmvp.databinding.BottomSheetMovieInfoLayoutBinding
import com.example.kotlinmvp.model.EmployeeModel
import com.example.kotlinmvp.model.MovieModel

class MovieInfoBottomSheet(
    private val movie: MovieModel,
    private val itemClickListener: ItemClickListener<MovieModel>
) :
    BaseBottomSheet<BottomSheetMovieInfoLayoutBinding>() {

    override fun initBinding(): BottomSheetMovieInfoLayoutBinding {
        return BottomSheetMovieInfoLayoutBinding.inflate(layoutInflater)
    }

    override fun onBottomSheetCreated() {
        binding.tvMovieTitle.text = movie.title
        binding.tvReleaseDate.text = movie.releaseDate

        binding.btnEdit.setOnClickListener {
            itemClickListener.onItemClicked(movie, 0)
            dismiss()
        }
    }
}