package com.ayonymus.androidchallenge.presentation.listitems

import androidx.core.content.ContextCompat
import com.ayonymus.androidchallenge.R
import com.ayonymus.androidchallenge.domain.entity.Transaction
import com.ayonymus.androidchallenge.presentation.satoshiToBtc
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_transaction.view.*
import java.text.SimpleDateFormat
import java.util.*

class TransactionItem(private val transaction: Transaction): Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.apply {
            text_transaction_value.text = transaction.value.satoshiToBtc()
            text_date.text = dateFormat.format(Date(transaction.time * 1000))
            imageView.setImageDrawable(ContextCompat.getDrawable(context, if (transaction.value >= 0) {
                R.drawable.ic_bitcoin_in
            } else {
                R.drawable.ic_bitcoin_out
            }))
        }

    }

    override fun getLayout() = R.layout.item_transaction

    companion object {
        // This is not the best solution for internationalization. Maybe jodatime would be better.
        private val dateFormat = SimpleDateFormat("MM/dd/yyyy HH:mm", Locale.UK)
    }

}
