package com.example.dicerollergooglecourse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Getting a reference of the button Id
        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener { rollDice() }


        // Calling the function after starting the app to roll the dice at the start
        rollDice()

    }

    private fun rollDice() {

        // Our first Dice with 6 Sides and doing our dice roll
        val firstDice = Dice(6)
        val diceRoll = firstDice.roll()

        // Our second Dice with 6 sides as well
        val secondDice = Dice(6)
        val secondDiceRoll = secondDice.roll()

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Find the second ImageView in the layout
        val secondDiceImage: ImageView = findViewById(R.id.imageView2)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val secondDrawableResource = when (secondDiceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Determine which drawable resource Id to use based on the dice roll
        diceImage.setImageResource(drawableResource)
        secondDiceImage.setImageResource((secondDrawableResource))

        //Update the content description
        diceImage.contentDescription = diceRoll.toString()
        secondDiceImage.contentDescription = secondDiceRoll.toString()

    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}