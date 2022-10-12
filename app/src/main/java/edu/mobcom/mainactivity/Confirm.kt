package edu.mobcom.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class Confirm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)

        val orderDetails = findViewById<EditText>(R.id.etOrderDetails)
        val orderTV = findViewById<TextView>(R.id.orderDetails)

        val recipientString = intent.getStringExtra("Recipient")
        val customerString = intent.getStringExtra("Customer")
        val numberString = intent.getStringExtra("Customer_CN")
        val emailString = intent.getStringExtra("Customer_Email")
        val beverageString = intent.getStringExtra("Beverage")
        val foodString = intent.getStringExtra("Food")

        orderTV.text = "Recipient $recipientString\nName: $customerString\nContact Number: $numberString\nEmail Address: $emailString" +
                "\n\n\nOrders:\nFood: $foodString\nBeverage: $beverageString"

        orderDetails.setText("Recipient $recipientString\nName: $customerString\nContact Number: $numberString\nEmail Address: $emailString" +
                "\n\n\nOrders:\nFood: $foodString\nBeverage: $beverageString")
    }
}