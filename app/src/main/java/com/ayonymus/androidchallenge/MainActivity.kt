package com.ayonymus.androidchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ayonymus.androidchallenge.presentation.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showMainFragment()
    }

    private fun showMainFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MainFragment(), null)
            .commit()
    }
}
