package com.ayon.marvel.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ayon.marvel.R
import dagger.android.support.DaggerFragment
import timber.log.Timber
import javax.inject.Inject

class SearchFragment(): DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by lazy { ViewModelProvider(this, viewModelFactory).get(SearchViewModel::class.java) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_comic_list, container, false)
    }

    override fun onResume() {
        super.onResume()
        viewModel.observeLiveData().observe(this,
            Observer { state ->  Timber.v(state.toString())
            })

    }
}