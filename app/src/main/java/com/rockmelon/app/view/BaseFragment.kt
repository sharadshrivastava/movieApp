package com.rockmelon.app.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.rockmelon.app.MovieApp
import com.rockmelon.app.R
import com.rockmelon.app.utils.Utils
import com.rockmelon.app.view.adapter.MoviesAdapter
import com.rockmelon.app.view.adapter.HorizontalSpaceItemDecoration

abstract class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        setHasOptionsMenu(true)
    }

    //Other child list fragments can also use, so keeping it in base fragment.
    fun setupListView(listView: RecyclerView?) {
        listView?.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(listView?.context)
        layoutManager.orientation= LinearLayoutManager.HORIZONTAL
        listView?.layoutManager = layoutManager
        var space = MovieApp.get().resources.getDimension(R.dimen.std_short_margin)
        listView?.addItemDecoration(HorizontalSpaceItemDecoration(Utils.pxFromDp(listView?.context, space).toInt()))
    }
}

