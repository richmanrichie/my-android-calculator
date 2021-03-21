package com.example.mycalculatorapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var operation = "*"
    var oldNumber = ""
    var isNewOperation = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buNumberSelect(view: View) {
        if (isNewOperation) calc_result.text = ""
        isNewOperation = false
        val buttonSelected = view as Button
        var selectedValue = calc_result.text.toString()
        when(buttonSelected.id) {
            bu0.id -> {
                selectedValue += "0"
            }
            bu1.id -> {
                selectedValue += "1"
            }
            bu2.id -> {
                selectedValue += "2"
            }
            bu3.id -> {
                selectedValue += "3"
            }
            bu4.id -> {
                selectedValue += "4"
            }
            bu5.id -> {
                selectedValue += "5"
            }
            bu6.id -> {
                selectedValue += "6"
            }
            bu7.id -> {
                selectedValue += "7"
            }
            bu8.id -> {
                selectedValue += "8"
            }
            bu9.id -> {
                selectedValue += "9"
            }
            buDot.id -> {
                selectedValue += "."
            }
            buPM.id -> {
                selectedValue = if (selectedValue != "0") "-$selectedValue" else selectedValue
            }
            else -> {}
        }

        calc_result.text = selectedValue
        Log.d("Select Number", calc_result.text.toString())
    }

    fun buOpEvent(view: View) {
        val buttonSelected = view as Button
        when(buttonSelected.id) {
            buMul.id -> {
                operation = "*"
            }
            buPlus.id -> {
                operation = "+"
            }
            buDiv.id -> {
                operation = "/"
            }
            buMinus.id -> {
                operation = "-"
            }
            else -> {
                return
            }
        }

        oldNumber = calc_result.text.toString()
        isNewOperation = true
    }

    fun buEqual(view: View?) {
        val newNumber = calc_result.text.toString()
        var finalNumber: Double? = null
        when(operation) {
            "*" -> {
                finalNumber =  oldNumber.toDouble() * newNumber.toDouble()
            }
            "+" -> {
                finalNumber =  oldNumber.toDouble() + newNumber.toDouble()
            }
            "-" -> {
                finalNumber =  oldNumber.toDouble() + newNumber.toDouble()
            }
            "/" -> {
                finalNumber =  oldNumber.toDouble() / newNumber.toDouble()
            }
        }

        calc_result.text = finalNumber.toString()

    }

    fun buClear(view: View) {
        calc_result.text = "0"
        isNewOperation = true
    }

    fun buPercent(view: View) {
        val current = calc_result.text.toString().toDouble()
        calc_result.text = (current/100).toString()
        isNewOperation = true
    }
}