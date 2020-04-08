package com.ayon.marvel.presentation.items

import android.view.View
import com.ayon.marvel.R
import com.ayon.marvel.domain.model.Comic
import com.squareup.picasso.Picasso
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_comic.view.*

class ComicItem(private val comic: Comic,
                private val onClick: (comic: Comic, picture: View) -> Unit
): Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.apply {
            Picasso.get()
                .load(comic.thumbnail)
                .placeholder(R.drawable.ic_marvellogo)
                .into(imageView_comic_thumbnail)

            textView_comic_title.text = comic.title
            imageView_comic_thumbnail.transitionName = TRANSACTION_ID_THUMBNAIL + position
            setOnClickListener { onClick(comic, imageView_comic_thumbnail) }
        }
    }

    override fun getLayout() = R.layout.item_comic

    companion object {
        val TRANSACTION_ID_THUMBNAIL = "comic_thumbnail_"
    }
}