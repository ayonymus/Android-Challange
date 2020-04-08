package com.ayon.marvel.presentation

import android.os.Bundle
import android.transition.*
import android.transition.TransitionSet.ORDERING_TOGETHER
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayon.core.view.listitems.SingleTextItem
import com.ayon.marvel.R
import com.ayon.marvel.domain.model.Comic
import com.ayon.marvel.domain.model.DataState
import com.ayon.marvel.presentation.items.ComicHeaderItem
import com.ayon.marvel.presentation.items.ComicItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_comic_list.*
import timber.log.Timber
import javax.inject.Inject

class ComicListMarvelFragment: DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by lazy { ViewModelProvider(this, viewModelFactory).get(ComicListViewModel::class.java) }

    private val groupAdapter = GroupAdapter<GroupieViewHolder>()
    private val mainSection = Section()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        groupAdapter.add(mainSection)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_comic_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = groupAdapter
        }
        // this is displayed until no other items are added to section
        mainSection.apply {
            setHeader(ComicHeaderItem())
            setPlaceholder(SingleTextItem(getString(R.string.loading)))
        }
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
        mainSection.update(data.map {
            ComicItem(
                it,
                ::startDetailsFragment
            )
        })
        groupAdapter.notifyDataSetChanged()
    }

    private fun startDetailsFragment(comic: Comic, picture: View) {
        val details = ComicDetailsFragment.newInstance(comic, picture.transitionName).apply {
            sharedElementEnterTransition = createTransitionSet()
            enterTransition = Fade()
            exitTransition = Fade()
            sharedElementReturnTransition = createTransitionSet()
        }

        activity?.apply {
            supportFragmentManager.beginTransaction()
                .addSharedElement(picture, picture.transitionName)
                .replace(R.id.fragment_container, details)
                .addToBackStack(null)
                .commit()
        }
    }

    private fun showLoading() {
        Timber.v("Loading") // TODO show loading
    }

    private fun showError() {
        Timber.v("Error")
        Toast.makeText(context, R.string.error, Toast.LENGTH_SHORT).show()

    }

    private fun createTransitionSet(): TransitionSet = TransitionSet().apply {
         ordering = ORDERING_TOGETHER
         addTransition(ChangeBounds())
         addTransition(ChangeTransform())
         addTransition(ChangeImageTransform())
    }

}
