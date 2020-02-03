package com.example.higher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_layer_lower.*

class HigherLowerActivity : AppCompatActivity() {

    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layer_lower)
        initViews()
    }

    /**
     * Set the initial (UI) state of the game.
     */
    private fun initViews() {
        updateUI()
    }

    /**
     * Update the last throw text and the dice image resource drawable with the current throw.
     */
    private fun updateUI() {
        tvLastThrow.text = getString(R.string.lastThrow, lastThrow)


    }
}




