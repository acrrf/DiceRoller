package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import com.example.android.diceroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }
        val countButton: Button = findViewById(R.id.count_up)
        countButton.setOnClickListener { countup() }

    }
    private fun rollDice(){
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
        }



        /*Toast.makeText(this, "button clicked",
            Toast.LENGTH_SHORT).show()*/
    }
    //DESAFIO DO BOTÃO COUNT
    private fun countup(){
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
}

