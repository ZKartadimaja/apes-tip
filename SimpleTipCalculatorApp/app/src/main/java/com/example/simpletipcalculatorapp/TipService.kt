package com.example.simpletipcalculatorapp

import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.os.Bundle

class TipService {
    companion object {
        // calculateTip function outside MainActivity class
        fun calculateTip(
            billAmount: EditText,
            totalTipCost: TextView,
            totalCost: TextView,
            tipPercentage: Double
        ) {
            val billAmountText = billAmount.text.toString()
            if (billAmountText.isEmpty()) {
                Toast.makeText(billAmount.context, "Please Input Your Bill", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val billAmountTotal = billAmountText.toDouble()
                val tipAmount = billAmountTotal * tipPercentage
                val totalAllCost = billAmountTotal + tipAmount

                totalTipCost.text = "$" + String.format("%.2f", tipAmount)
                totalCost.text = "$" + String.format("%.2f", totalAllCost)
            }
        }
    }

}