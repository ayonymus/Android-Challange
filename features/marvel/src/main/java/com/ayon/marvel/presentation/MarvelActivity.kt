package com.ayon.marvel.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ayon.marvel.R


class MarvelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_container)
        showMainFragment()
    }

    private fun showMainFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,
                ComicListMarvelFragment(), null)
            .commit()
    }


}