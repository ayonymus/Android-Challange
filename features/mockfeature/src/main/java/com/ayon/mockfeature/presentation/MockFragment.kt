package com.ayon.mockfeature.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayon.mockfeature.R
import com.ayon.mockfeature.domain.MockData
import com.ayon.core.view.listitems.SingleTextItem
import com.ayon.mockfeature.domain.DataState
import com.google.android.material.snackbar.Snackbar
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_main.*
import timber.log.Timber
import javax.inject.Inject

class MockFragment: DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MockFragmentViewModel

    private val groupAdapter = GroupAdapter<GroupieViewHolder>()
    private val mainSection = Section()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MockFragmentViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
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

    private fun displayData(data: MockData) {
        Timber.v(data.toString())
        mainSection.update(data.data.map { SingleTextItem(it) })
        groupAdapter.notifyDataSetChanged()
    }

    private fun showLoading() {
        Timber.v("Loading") // TODO show loading
    }

    private fun showError() {
        Snackbar.make(main_fragment_layout, R.string.error, Snackbar.LENGTH_LONG).show()
        Timber.v("Error")
    }

}
