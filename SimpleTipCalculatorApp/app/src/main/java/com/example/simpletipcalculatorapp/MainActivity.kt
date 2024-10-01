package com.example.simpletipcalculatorapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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

        buttonTip10Percentage.setOnClickListener {
            calculateTip(billAmount, totalTipCost, totalCost, 0.1)
        }
        buttonTip15Percentage.setOnClickListener {
            calculateTip(billAmount, totalTipCost, totalCost, 0.15)
        }
        buttonTip20Percentage.setOnClickListener {
            calculateTip(billAmount, totalTipCost, totalCost, 0.2)
        }
    }
}

// calculateTip function outside MainActivity class
fun calculateTip(billAmount: EditText, totalTipCost: TextView, totalCost: TextView, tipPercentage: Double) {
    val billAmountText = billAmount.text.toString()
    if (billAmountText.isEmpty()) {
        return
    } else {
        val billAmountTotal = billAmountText.toDouble()
        val tipAmount = billAmountTotal * tipPercentage
        val totalAllCost = billAmountTotal + tipAmount

        totalTipCost.text = "Tip Amount: $" + String.format("%.2f", tipAmount)
        totalCost.text = "Total Cost: $" + String.format("%.2f", totalAllCost)
    }
}