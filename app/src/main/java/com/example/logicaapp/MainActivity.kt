package com.example.logicaapp

import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    // array of answers you can give
    private val listOfChoices = arrayOf("T", "F")

    // Total points you get by answering the questions correctly
    private var points: Int = 0


    private var userSelect = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createSpinners()
    }

    fun createSpinners() {
        //get the spinner object by its id
        val spinner: Spinner = findViewById(R.id.spinner)
        val spinner2: Spinner = findViewById(R.id.spinner2)
        val spinner3: Spinner = findViewById(R.id.spinner3)
        val spinner4: Spinner = findViewById(R.id.spinner4)
        val submitButton: Button = findViewById(R.id.submit)

        // Create an ArrayAdapter using the string array and a default spinner layout
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listOfChoices)
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        spinner.adapter = adapter
        spinner2.adapter = adapter
        spinner3.adapter = adapter
        spinner4.adapter = adapter


        // initialize arraylist to put the spinners in
        val listSpinners = arrayListOf(spinner, spinner2, spinner3, spinner4)


        // go through all the spinners with a for loop
        for (spinnerTo in listSpinners) {


            //override the selection methods of the class OnItemSelectedListener on each spinner
            spinnerTo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    choice1.text = "?"
                    choice2.text = "?"
                    choice3.text = "?"
                    choice4.text = "?"
                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    if (parent != null) {
                        if(parent.getItemAtPosition(position) != "T" || parent.getItemAtPosition(position) != "F"){
                            //Do nothing
                        }

                        // kotlin equivalent of switch statment.
                        // this when method checks which parent is called and changes the string outputted in the
                        //spinner dependend of the spinner used
                            when (parent) {
                                spinner -> {
                                    choice1.text = listOfChoices[position]
                                    if (listOfChoices[position] == "T") {
                                        points++
                                    }
                                }
                                spinner2 -> {
                                    choice2.text = listOfChoices[position]
                                    if (listOfChoices[position] == "F") {
                                        points++
                                    }
                                }
                                spinner3 -> {
                                    choice3.text = listOfChoices[position]
                                    if (listOfChoices[position] == "F") {
                                        points++
                                    }
                                }
                                spinner4 -> {
                                    choice4.text = listOfChoices[position]
                                    if (listOfChoices[position] == "F") {
                                        points++
                                    }
                                }
                            }
                    }


                }


            }

                //finally , show the amount of questions you answered correctly
                submitButton.setOnClickListener {
                    Toast.makeText(
                        this@MainActivity,
                        "The correct number of answers is: $points",
                        LENGTH_SHORT
                    ).show()
                    points = 0


                    //call the createspinners method again so the spinner listeners are called again
                    createSpinners()
                }
            }
        }


    }











