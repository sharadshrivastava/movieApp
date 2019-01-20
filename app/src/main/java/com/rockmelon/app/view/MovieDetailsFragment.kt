package com.rockmelon.app.view

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.rockmelon.app.R
import com.rockmelon.app.databinding.FragmentMovieDetailsBinding
import com.rockmelon.app.service.model.MoviesItem
import com.rockmelon.app.utils.Utils.KEY_ITEM
import com.rockmelon.app.viewmodel.MovieDetailsViewModel

class MovieDetailsFragment : BaseFragment(){

    private lateinit var vm: MovieDetailsViewModel
    private lateinit var binding: FragmentMovieDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var item = arguments?.getParcelable<MoviesItem>(KEY_ITEM)
        ViewModelProviders.of(this, MovieDetailsViewModel.MovieDetailsViewModelFactory(
            activity!!.application, item)).get(MovieDetailsViewModel::class.java!!)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_details, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    companion object {
        fun create(item: MoviesItem?):MovieDetailsFragment{
            var fragment =  MovieDetailsFragment()
            var bundle = Bundle()
            bundle.putParcelable(KEY_ITEM, item)
            fragment.arguments = bundle

            return fragment
        }
    }
}