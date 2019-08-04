package com.ayonymus.androidchallenge.presentation.listitems

import androidx.annotation.StringRes
import com.ayonymus.androidchallenge.R
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_single_text.view.*

class SingleTextItem(@StringRes private val text: Int): Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.item_single_text_content.setText(text)
    }

    override fun getLayout() = R.layout.item_single_text

}
