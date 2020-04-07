package com.ayon.marvel.presentation

import com.ayon.marvel.R
import com.ayon.marvel.domain.model.Comic
import com.squareup.picasso.Picasso
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_comic.view.*

class ComicItem(private val comic: Comic,
                private val onClick: (comic: Comic) -> Unit
): Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.apply {
            Picasso.get()
                .load(comic.thumbnail)
                .placeholder(R.drawable.ic_marvellogo)
                .into(imageView_comic_thumbnail)

            textView_comic_title.text = comic.title
            textView_comic_description.text = comic.description
            setOnClickListener { onClick(comic) }
        }
    }

    override fun getLayout() = R.layout.item_comic
}