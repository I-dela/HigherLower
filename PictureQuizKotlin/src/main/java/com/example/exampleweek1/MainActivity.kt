package com.example.exampleweek1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // when clicked on confirm button execute checkAnswer method
        confirmAnswer.setOnClickListener {
            checkAnswer()
        }

    }

    /**
     * Check if the submitted answer is correct.
     */
    private fun checkAnswer() {
        val answer = inputGiraffe.text.toString()

        // if the answer is equal to "giraffe" with or without capital show toast with message correct otherwise
        //show message with message incorrect
        if (answer == getString(R.string.inputGiraffeAnswer) || answer == getString(R.string.inputGiraffeAnswerWithoutCapital)) {
          return Toast.makeText(
                this.applicationContext,
                getString(R.string.AnswerIsCorrect),
                Toast.LENGTH_LONG
            ).show()
        }


        Toast.makeText(
            this.applicationContext,
            getString(R.string.AnswerIsWrong),
            Toast.LENGTH_LONG
        ).show()


    }
}
