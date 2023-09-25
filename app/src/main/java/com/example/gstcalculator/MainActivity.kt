package com.example.gstcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.gstcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnTwozero?.setOnClickListener { appendInput("00") }
        binding.btnZero?.setOnClickListener { appendInput("0") }
        binding.btnOne?.setOnClickListener { appendInput("1") }
        binding.btnTwo?.setOnClickListener { appendInput("2") }
        binding.btnThree?.setOnClickListener { appendInput("3") }
        binding.btnFour?.setOnClickListener { appendInput("4") }
        binding.btnFive?.setOnClickListener { appendInput("5") }
        binding.btnSix?.setOnClickListener { appendInput("6") }
        binding.btnSeven?.setOnClickListener { appendInput("7") }
        binding.btnEight?.setOnClickListener { appendInput("8") }
        binding.btnNine?.setOnClickListener { appendInput("9") }

        //math operations
        binding.btnDivision?.setOnClickListener { appendInput("/") }
        binding.btnMulti?.setOnClickListener { appendInput("X") }
        binding.btnMinus?.setOnClickListener { appendInput("-") }
        binding.btnPlus?.setOnClickListener { appendInput("+") }
        //binding.btnEqual?.setOnClickListener { appendInput("") }

        binding.btnBacksppace?.setOnClickListener {
            handleBackspaceClick()
        }


    }

        private fun appendInput(input: String) {
            val currentText = binding.ipCal?.text.toString()
            val newText = currentText + input
            binding.ipCal?.setText(newText)
            binding.ipCal?.text?.let { binding.ipCal?.setSelection(it.length) }

        }

        private fun handleBackspaceClick() {
            val currentText = binding.ipCal?.text.toString()
            if (currentText.isNotEmpty()) {
                val newText = currentText.substring(0, currentText.length - 1)
                binding.ipCal?.setText(newText)
            }
        }

}

