package edu.mobcom.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class Order : AppCompatActivity() {
    lateinit var orderBtn: Button
    lateinit var homeBtn: Button
    lateinit var bevSpinner: Spinner
    lateinit var foodSpinner: Spinner
    lateinit var compEmail: EditText
    lateinit var custEmail: EditText
    lateinit var custName: EditText
    lateinit var custNum: EditText
    lateinit var bevOrder: String
    lateinit var foodOrder: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        orderBtn = findViewById(R.id.btnOrder)
        homeBtn = findViewById(R.id.btnHome)
        bevSpinner = findViewById(R.id.spnrBev)
        foodSpinner = findViewById(R.id.spnrFood)
        compEmail = findViewById(R.id.txtEmail)
        custEmail = findViewById(R.id.txtCustEmail)
        custName = findViewById(R.id.txtName)
        custNum = findViewById(R.id.txtNum)


        val beverages = resources.getStringArray(R.array.bev_array)

        val food = resources.getStringArray(R.array.food_array)



        bevSpinner.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                bevOrder = bevSpinner.selectedItem.toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@Order, "Nothing selected", Toast.LENGTH_SHORT).show()
            }
        }

        foodSpinner.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                foodOrder = foodSpinner.selectedItem.toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@Order, "Nothing selected", Toast.LENGTH_SHORT).show()
            }
        }

        orderBtn.setOnClickListener {
            val iOrder = Intent(this@Order, Confirm::class.java)

            iOrder.putExtra("Recipient", compEmail.text.toString())
            iOrder.putExtra("Customer", custName.text.toString())
            iOrder.putExtra("Customer_CN", custNum.text.toString())
            iOrder.putExtra("Customer_Email", custEmail.text.toString())
            iOrder.putExtra("Beverage", bevOrder)
            iOrder.putExtra("Food", foodOrder)

            startActivity(iOrder)

        }
        homeBtn.setOnClickListener {
            val iHome = Intent(this@Order, MainActivity::class.java)
            startActivity(iHome)
        }
    }
}