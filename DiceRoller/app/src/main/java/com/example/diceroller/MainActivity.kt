package com.example.diceroller

import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll the dice
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val drawableResource = arrayOf(
            R.drawable.dice_1,
            R.drawable.dice_2,
            R.drawable.dice_3,
            R.drawable.dice_4,
            R.drawable.dice_5,
            R.drawable.dice_6
        )
        //Find the TextView2 in the layout
        val rollText: TextView = findViewById(R.id.textView2)
        val initRollTextTitle = "You rolled :"

        rollText.text = "${initRollTextTitle} ${diceRoll}"
        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource[diceRoll - 1])

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }
    // Determine which drawable resource ID to use based on the dice roll
}


class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}