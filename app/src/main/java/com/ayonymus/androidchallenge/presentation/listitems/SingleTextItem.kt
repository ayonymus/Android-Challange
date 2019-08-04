package com.ayonymus.androidchallenge.presentation.listitems

import com.ayonymus.androidchallenge.R
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_single_text.view.*

class SingleTextItem(private val resolvedText: String): Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.item_single_text_content.apply {
            text = resolvedText
        }
    }

    override fun getLayout() = R.layout.item_single_text

    override fun isSameAs(other: com.xwray.groupie.Item<*>?): Boolean {
        return when(other) {
            is SingleTextItem -> resolvedText.contentEquals(other.resolvedText)
            else -> false
        }
    }
}
