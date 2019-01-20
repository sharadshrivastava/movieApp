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
}

