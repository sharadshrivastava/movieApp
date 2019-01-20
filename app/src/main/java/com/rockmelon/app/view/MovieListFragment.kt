package com.rockmelon.app.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.rockmelon.app.R
import com.rockmelon.app.databinding.FragmentMovieListBinding
import com.rockmelon.app.service.Resource
import com.rockmelon.app.service.model.MoviesItem
import com.rockmelon.app.view.adapter.OnMovieClickListener
import com.rockmelon.app.view.adapter.MoviesAdapter
import com.rockmelon.app.viewmodel.MovieListViewModel


class MovieListFragment : BaseFragment(), OnMovieClickListener {

    private lateinit var binding: FragmentMovieListBinding
    private lateinit var vm: MovieListViewModel
    private var adapter: MoviesAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProviders.of(this).get(MovieListViewModel::class.java)
        observeMovieLiveData()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_list, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupMoviesList(null)
        (activity as MainActivity).supportActionBar?.title = getString(R.string.movies)
    }

    private fun setupMoviesList(list: MutableList<MoviesItem?>?) {
        if (adapter == null) {
            adapter = MoviesAdapter(this, list)
            binding.isLoading = true
        }
        vm.setupListView(binding.rvMovieList, adapter)
    }

    private fun observeMovieLiveData() {
        vm.getMovies().observe(this, Observer{ resource ->
            if (resource?.status == Resource.Status.SUCCESS) {
                binding.isLoading = false

                refreshMovies(resource.data)
            } else {
                binding.isLoading = false
                Snackbar.make(binding.root, resource?.message?:"Error", Snackbar.LENGTH_LONG).show()
            }
        })
    }

    private fun refreshMovies(list:List<MoviesItem?>?) {
        adapter?.setData(list)
    }

    override fun onMovieClick(moviesItem: MoviesItem?) {
       // launchMap(bundle)
    }

    companion object {
        fun create() = MovieListFragment()
    }
}