package com.ayon.core.view.listitems

import com.ayon.core.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_single_text.view.*

class SingleTextItem(private val resolvedText: String): Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.item_single_text_content.apply {
            text = resolvedText
        }
    }

    override fun getLayout() = R.layout.item_single_text

    override fun isSameAs(other: com.xwray.groupie.Item<*>) =
        when(other) {
            is SingleTextItem -> resolvedText.contentEquals(other.resolvedText)
            else -> false
        }
}
