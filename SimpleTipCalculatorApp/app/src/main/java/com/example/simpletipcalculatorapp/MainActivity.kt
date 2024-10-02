package com.example.simpletipcalculatorapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.simpletipcalculatorapp.R


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val billAmount = findViewById<EditText>(R.id.bill_amount_edit_text)
        val buttonTip10Percentage = findViewById<Button>(R.id.tip_10_button)
        val buttonTip15Percentage = findViewById<Button>(R.id.tip_15_button)
        val buttonTip20Percentage = findViewById<Button>(R.id.tip_20_button)
        val totalCost = findViewById<TextView>(R.id.total_cost_text_view)
        val totalTipCost = findViewById<TextView>(R.id.tip_amount_text_view)
        val errorMessage = findViewById<TextView>(R.id.textView2)

        buttonTip10Percentage.setOnClickListener {
            calculateTip(billAmount, totalTipCost, totalCost, 0.1, errorMessage)
        }
        buttonTip15Percentage.setOnClickListener {
            calculateTip(billAmount, totalTipCost, totalCost, 0.15, errorMessage)
        }
        buttonTip20Percentage.setOnClickListener {
            calculateTip(billAmount, totalTipCost, totalCost, 0.2, errorMessage)
        }
    }
}

// calculateTip function outside MainActivity class
fun calculateTip(billAmount: EditText,
                 totalTipCost: TextView, totalCost: TextView,
                 tipPercentage: Double, errorMessageText: TextView) {
    val billAmountText = billAmount.text.toString()
    if (billAmountText.isEmpty()) {
        errorMessageText.setText("Please Input Your Bill")
    } else {
        val billAmountTotal = billAmountText.toDouble()
        val tipAmount = billAmountTotal * tipPercentage
        val totalAllCost = billAmountTotal + tipAmount

        totalTipCost.text = "$" + String.format("%.2f", tipAmount)
        totalCost.text = "$" + String.format("%.2f", totalAllCost)
    }
}