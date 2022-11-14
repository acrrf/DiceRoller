package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.text.isDigitsOnly
import com.example.android.diceroller.databinding.ActivityMainBinding

/*class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }
        val countButton: Button = findViewById(R.id.count_up)
        countButton.setOnClickListener { countup() }

    }*/
    /*private fun rollDice(){
        //val resultText: TextView = findViewById(R.id.result_text)
        //resultText.text = "Dice Rolled!"

        val randomLimite: EditText = findViewById(R.id.count_lados)
        if(randomLimite.text.toString() == ""){
            val randomInt = (1..6).random()
            binding.resultText.text = randomInt.toString()
        }else if(randomLimite.text.isDigitsOnly()){
            val randomInt = (1..((randomLimite.text.toString()).toInt())).random()
            binding.resultText.text = randomInt.toString()
        }else{
            binding.resultText.text = "Dice Roller!"
        }*/



        /*Toast.makeText(this, "button clicked",
            Toast.LENGTH_SHORT).show()
    }*/


    //DESAFIO DO BOTÃO COUNT
    /*private fun countup(){
        val resultText: TextView = findViewById(R.id.result_text)
        if(resultText.text == "Dice Roller!"){
            resultText.text = "1"
        }else if(resultText.text.toString().toInt() == 6) {
            resultText.text = resultText.text.toString()
        }else if(resultText.text.toString().toInt() > 6){
                resultText.text = "6"
        }else{
            val resultcount = (resultText.text.toString()).toInt() + 1
            resultText.text = resultcount.toString()
        }



    }
}*/


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Rolou o dado!", Toast.LENGTH_SHORT).show()

            rollDice()
        }
    }
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val diceImage: ImageView = findViewById(R.id.imageView)


        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice (val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}

