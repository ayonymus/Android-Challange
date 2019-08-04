package com.ayonymus.androidchallenge.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayonymus.androidchallenge.App
import com.ayonymus.androidchallenge.R
import com.ayonymus.androidchallenge.presentation.listitems.SingleTextItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment: Fragment() {

    private val groupAdapter = GroupAdapter<ViewHolder>()
    private val mainSection = Section()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        App.getComponent().inject(this)
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = groupAdapter
        }
        // this is displayed until no other items are added to section
        mainSection.setPlaceholder(SingleTextItem(R.string.loading))
        groupAdapter.add(mainSection)
    }

}
