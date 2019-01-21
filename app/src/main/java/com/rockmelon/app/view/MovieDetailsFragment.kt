package com.rockmelon.app.view

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.rockmelon.app.R
import com.rockmelon.app.databinding.FragmentMovieDetailsBinding
import com.rockmelon.app.service.model.MoviesItem
import com.rockmelon.app.utils.Utils
import com.rockmelon.app.utils.Utils.KEY_ITEM
import com.rockmelon.app.viewmodel.MovieDetailsViewModel



class MovieDetailsFragment : BaseFragment(){

    private lateinit var vm: MovieDetailsViewModel
    private lateinit var binding: FragmentMovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var item = arguments?.getParcelable<MoviesItem>(KEY_ITEM)
        vm = ViewModelProviders.of(this, MovieDetailsViewModel.MovieDetailsViewModelFactory(
            activity!!.application, item)).get(MovieDetailsViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_details, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.item = vm.getMoviesItem()
        Utils.loadImage(binding.ivMoviePoster, vm.getMoviesItem()?.poster)
        addCast()
        addProducers()
        addDirector()
        addWriters()
    }

    private fun addCast(){
        for(name in vm.getMoviesItem()?.actors.orEmpty()) {
           addView(name, binding.llCastCrew)
        }
    }

    // There are no producers in json data so considering writers.
    private fun addProducers(){
        for(name in vm.getMoviesItem()?.writers.orEmpty()) {
            addView(name, binding.llProducers)
        }
    }

    private fun addDirector(){
        addView(vm.getMoviesItem()?.director, binding.llDirectors)
    }

    private fun addWriters(){
        for(name in vm.getMoviesItem()?.writers.orEmpty()) {
            addView(name, binding.llWriters)
        }
    }

    private fun addView(name:String?, viewGroup: ViewGroup){
        var castView = layoutInflater.inflate(R.layout.layout_text, null, false) as TextView
        castView.text  = name
        viewGroup.addView(castView)
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