package com.rockmelon.app.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.rockmelon.app.utils.Utils
import com.rockmelon.app.view.adapter.MoviesAdapter
import com.rockmelon.app.view.adapter.HorizontalSpaceItemDecoration

abstract class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        setHasOptionsMenu(true)
    }

    //Keeping it in base fragment so it will be available for all future lists in real project.
    protected fun setupListView(listView: RecyclerView?, adapter: MoviesAdapter?) {
        listView?.setHasFixedSize(true)
        val mLayoutManager = LinearLayoutManager(context)
        mLayoutManager.orientation= LinearLayoutManager.HORIZONTAL
        listView?.layoutManager = mLayoutManager
        listView?.adapter = adapter
        listView?.addItemDecoration(HorizontalSpaceItemDecoration(Utils.pxFromDp(context, 24f).toInt()))
    }
}

