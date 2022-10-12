package edu.mobcom.mainactivity

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webBtn: Button = findViewById(R.id.btnWeb)
        val mailBtn: Button = findViewById(R.id.btnMail)
        val toastBtn: Button = findViewById(R.id.btnToast)
        val nxtBtn: Button = findViewById(R.id.btnNext)
        val dialBtn: Button = findViewById(R.id.btnDial)
        val eScheduler: Button = findViewById(R.id.btnES)
        val order: Button = findViewById(R.id.btnOrder)

        nxtBtn.setOnClickListener {
            val i = Intent(this, MainActivity2::class.java)
            startActivity(i)
        }

        webBtn.setOnClickListener {
            val strURL = "https://www.ubaguio.edu"
            val iBrowser = Intent(Intent.ACTION_VIEW, Uri.parse(strURL))
            startActivity(iBrowser)
        }

        dialBtn.setOnClickListener {
            val iDialer = Intent(Intent.ACTION_DIAL)
            startActivity(iDialer)
        }

        //send email
        val txtMsg = "Hello there"
        val errMsg = "No message found."
        val iMessage = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, txtMsg)
            type = "text/plain"
        }

        mailBtn?.setOnClickListener {
            try{
                startActivity(iMessage)
            }catch(e: ActivityNotFoundException){
                Toast.makeText(this@MainActivity, errMsg, Toast.LENGTH_SHORT).show()
            }
        }

        toastBtn.setOnClickListener {
            Toast.makeText(this@MainActivity, "Hello I am a disguised Toast", Toast.LENGTH_SHORT).show()
        }

        eScheduler.setOnClickListener {
            val eventSchedulerIntent = Intent(this, EventScheduler::class.java)
            startActivity(eventSchedulerIntent)
        }

        order.setOnClickListener {
            val iOrder = Intent(this@MainActivity, Order::class.java)
            startActivity(iOrder)
        }
    }
}