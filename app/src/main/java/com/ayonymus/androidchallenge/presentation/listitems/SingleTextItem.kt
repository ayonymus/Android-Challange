package com.ayonymus.androidchallenge.presentation.listitems

import android.os.Build
import androidx.annotation.StyleRes
import com.ayonymus.androidchallenge.R
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_single_text.view.*

class SingleTextItem(private val resolvedText: String,
                     @StyleRes private val textAppearance: Int? = null): Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.item_single_text_content.apply {
            text = resolvedText
            textAppearance?.let {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    setTextAppearance(it)
                } else {
                    setTextAppearance(context, it)
                }
            }
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
