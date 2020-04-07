package com.ayon.marvel.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.ayon.marvel.R
import com.ayon.marvel.domain.model.Comic
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_comic_details.*

class ComicDetailsFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_comic_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView_comic_details_thumbnail.transitionName = transition
    }

    override fun onResume() {
        super.onResume()
        populateFields()
    }

    private fun populateFields() {
        comic?.apply {
            Picasso.get()
                .load(thumbnail)
                .placeholder(R.drawable.ic_marvellogo)
                .into(imageView_comic_details_thumbnail)
            textView_comic_details_title.text = title
            textView_comic_details_description.text = description
        }
    }

    private val comic: Comic?
        get() = arguments?.getParcelable(KEY_COMIC)

    private val transition: String?
        get() = arguments?.getString(KEY_TRANSITION)

    companion object {
        private const val KEY_COMIC = "key_comic"
        private const val KEY_TRANSITION = "key_position"

        fun newInstance(comic: Comic, transitionName: String) = ComicDetailsFragment().apply {
            arguments = bundleOf(KEY_COMIC to comic, KEY_TRANSITION to transitionName)
        }
    }
}
