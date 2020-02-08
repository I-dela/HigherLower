package com.example.higher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
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
        higher.setOnClickListener {onHigherClick()}
        lower.setOnClickListener{onLowerClick()}
        equals.setOnClickListener{onEqualClick()}

        updateUI()

    }

    /**
     * Update the last throw text and the dice image resource drawable with the current throw.
     */
    private fun updateUI() {
        tvLastThrow.text = getString(R.string.lastThrow, lastThrow)

    }

    /**
     * This method replaces the previously dice value with the currentValue and
     * replaces the current dice with a new dice with a random number between 1 and 6 (6 included)
     */

    private fun rollDice(){
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()

    }

    /**
     * calls [rollDice]  and checks if the next throw is actually higher than the current dice.
     */
    private fun onHigherClick(){

        rollDice()

        // checks if the nextThrow(when button is clicked nextThrow is actually currentThrow and
        // previous currentThrow is lastthrow) is higher than lastThrow )

        if(currentThrow > lastThrow)
          return  onAnswerCorrect()


        onAnswerIncorrect()
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onLowerClick() {
        rollDice()
        if(currentThrow < lastThrow)
            return onAnswerCorrect()


        onAnswerIncorrect()

    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onEqualClick() {
        rollDice()
        if(currentThrow == lastThrow)
            return onAnswerCorrect()

        onAnswerIncorrect()

    }



    /**
     * Displays a successful Toast message.
     */
    private fun onAnswerCorrect() {
        val text = "Guess correct!"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(applicationContext, text, duration)
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
        toast.setGravity(Gravity.TOP or Gravity.CENTER, 0, 0)
        toast.show()
    }

}




