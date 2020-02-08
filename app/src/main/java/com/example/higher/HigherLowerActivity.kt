package com.example.higher

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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
        // set code to execute when button is tapped/clicked
        higher.setOnClickListener { onHigherClick() }
        lower.setOnClickListener { onLowerClick() }
        equals.setOnClickListener { onEqualClick() }

        updateUI()

    }

    /**
     * Update the last throw text and the dice image resource drawable with the current throw.
     */
    private fun updateUI() {
        tvLastThrow.text = getString(R.string.lastThrow, lastThrow)


        // set image into imageView dependent on the random number

        if (currentThrow == 1) {
            imageView.setImageResource(R.drawable.dice1)
        } else if (currentThrow == 2) {
            imageView.setImageResource(R.drawable.dice2)
        } else if (currentThrow == 3) {
            imageView.setImageResource(R.drawable.dice3)

        } else if (currentThrow == 4) {
            imageView.setImageResource(R.drawable.dice4)

        } else if (currentThrow == 5) {
            imageView.setImageResource(R.drawable.dice5)

        } else if (currentThrow == 6) {
            imageView.setImageResource(R.drawable.dice6)

        }


    }

    /**
     * This method replaces the previously dice value with the currentValue and
     * replaces the current dice with a new dice with a random number between 1 and 6 (6 included)
     */

    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()

    }

    /**
     * calls [rollDice]  and checks if the next throw is actually higher than the current dice.
     */
    private fun onHigherClick() {

        rollDice()

        // checks if the nextThrow(when button is clicked nextThrow is actually currentThrow and
        // previous currentThrow is lastthrow) is higher than lastThrow )

        if (currentThrow > lastThrow)
            return onAnswerCorrect()


        onAnswerIncorrect()
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onLowerClick() {
        rollDice()
        if (currentThrow < lastThrow)
            return onAnswerCorrect()


        onAnswerIncorrect()

    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onEqualClick() {
        rollDice()
        if (currentThrow == lastThrow)
            return onAnswerCorrect()

        onAnswerIncorrect()

    }


    /**
     * Displays a successful Toast message.
     */
    private fun onAnswerCorrect() {
        var text = "Guess correct!"
        val duration = Toast.LENGTH_SHORT

        var toast = Toast.makeText(applicationContext, text, duration)
        val txtToast : TextView = toast.view.findViewById(android.R.id.message)
        txtToast.setTextColor(Color.BLACK)
        toast.setGravity(Gravity.TOP or Gravity.CENTER, 0, 0)

        toast.show()
    }

    /**
     * Displays a incorrect Toast message.
     */
    private fun onAnswerIncorrect() {
        val text = "Guess incorrect!"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(applicationContext, text, duration)
        val txtToast : TextView = toast.view.findViewById(android.R.id.message)
        txtToast.setTextColor(Color.BLACK)
        toast.setGravity(Gravity.TOP or Gravity.CENTER, 0, 0)
        toast.show()
    }

}




