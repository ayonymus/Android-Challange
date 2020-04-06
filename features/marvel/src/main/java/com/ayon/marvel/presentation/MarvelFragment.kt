package com.ayon.marvel.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayon.core.view.listitems.SingleTextItem
import com.ayon.marvel.R
import com.ayon.marvel.domain.model.Comic
import com.ayon.marvel.domain.model.DataState
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_marvel.*
import timber.log.Timber
import javax.inject.Inject

class MarvelFragment: DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MarvelFragmentViewModel

    private val groupAdapter = GroupAdapter<GroupieViewHolder>()
    private val mainSection = Section()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MarvelFragmentViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_marvel, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = groupAdapter
        }
        // this is displayed until no other items are added to section
        mainSection.setPlaceholder(SingleTextItem(getString(R.string.loading)))
        groupAdapter.add(mainSection)
    }

    override fun onResume() {
        super.onResume()

        viewModel.getData().observe(this,
            Observer { state ->  when(state) {
                is DataState.Loading -> showLoading()
                is DataState.Failure -> showError()
                is DataState.Success -> displayData(state.data)
            }
            })
    }

    private fun displayData(data: List<Comic>) {
        Timber.v(data.toString())
        mainSection.update(data.map { SingleTextItem(it.title) })
        groupAdapter.notifyDataSetChanged()
    }

    private fun showLoading() {
        Timber.v("Loading") // TODO show loading
    }

    private fun showError() {
        // TODO
        Timber.v("Error")
    }

}
