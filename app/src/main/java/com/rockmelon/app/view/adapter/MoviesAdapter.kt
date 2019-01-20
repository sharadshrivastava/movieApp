package com.rockmelon.app.view.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

import com.rockmelon.app.R
import com.rockmelon.app.databinding.LayoutMovieRowBinding
import com.rockmelon.app.service.model.MoviesItem
import com.rockmelon.app.utils.Utils


class MoviesAdapter(
    private var clickListener: OnMovieClickListener
    , private var movieList: MutableList<MoviesItem?>?) :
    RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = DataBindingUtil.inflate<LayoutMovieRowBinding>(
            LayoutInflater.from(parent.context),
            R.layout.layout_movie_row, parent, false
        )
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindData(movieList?.get(position))
    }

    override fun getItemCount(): Int {
        return if (movieList == null) 0 else movieList!!.size
    }

    inner class MovieViewHolder(private var binding: LayoutMovieRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(movieItem: MoviesItem?) {
            binding.item = movieItem
            Utils.loadImage(binding.ivMoviePoster, movieItem?.poster)
            itemView.setOnClickListener { manageMovieClick(movieItem) }
        }

        private fun manageMovieClick(movieItem: MoviesItem?) {
            clickListener.onMovieClick(movieItem)
        }
    }

    fun setData(movies: List<MoviesItem?>?) {
        if (movieList != null) {
            movieList!!.clear()
            movieList!!.addAll(movies!!.toList())
        } else {
            movieList = movies?.toMutableList()
        }
        notifyDataSetChanged()
    }
}