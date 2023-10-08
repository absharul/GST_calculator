package com.example.gstcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.gstcalculator.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

open class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnZero?.setOnClickListener {binding.ipCal?.text = appendInpuText("0") }
        binding.btnOne?.setOnClickListener { binding.ipCal?.text = appendInpuText("1") }
        binding.btnTwo?.setOnClickListener {binding.ipCal?.text = appendInpuText("2") }
        binding.btnThree?.setOnClickListener {binding.ipCal?.text = appendInpuText("3") }
        binding.btnFour?.setOnClickListener {binding.ipCal?.text = appendInpuText("4") }
        binding.btnFive?.setOnClickListener {binding.ipCal?.text = appendInpuText("5") }
        binding.btnSix?.setOnClickListener {binding.ipCal?.text = appendInpuText("6") }
        binding.btnSeven?.setOnClickListener {binding.ipCal?.text = appendInpuText("7") }
        binding.btnEight?.setOnClickListener {binding.ipCal?.text = appendInpuText("8") }
        binding.btnNine?.setOnClickListener {binding.ipCal?.text = appendInpuText("9") }

        //math operations
        binding.btnDivision?.setOnClickListener {binding.ipCal?.text = appendInpuText("÷") }
        binding.btnMulti?.setOnClickListener {binding.ipCal?.text = appendInpuText("×") }
        binding.btnMinus?.setOnClickListener {binding.ipCal?.text = appendInpuText("-") }
        binding.btnPlus?.setOnClickListener {binding.ipCal?.text = appendInpuText("+") }
        binding.btnEqual?.setOnClickListener {showResult()}

        binding.btnClear?.setOnClickListener {
            binding.ipCal?.text = ""
            binding.resultView?.text = ""
        }





    }

    private fun appendInpuText(input: String): String{
        return "${binding.ipCal?.text}$input"
    }

    private fun getInputExpression(): String {
        var expression = binding.ipCal?.text?.replace(Regex("÷"), "/")
        expression = expression?.replace(Regex("×"), "*") // Use the safe call operator here
        return expression ?: "" // Return an empty string if expression is null
    }

    private fun showResult(){
        try{
          val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if(result.isNaN()){
             binding.resultView?.text = "Error"
             binding.resultView?.setTextColor(ContextCompat.getColor(this,R.color.clear_red))
            }
            else{
             binding.resultView?.text = DecimalFormat("0.######").format(result).toString()
             binding.resultView?.setTextColor(ContextCompat.getColor(this,R.color.black))
            }
        } catch (e: Exception) {
            binding.resultView?.text = "Error"
            binding.resultView?.setTextColor(ContextCompat.getColor(this,R.color.clear_red))
        }
    }


}



