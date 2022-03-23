package com.example.afinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val i = intent
        var txt1 = i.getStringExtra("txt1")
        var txt3 = i.getStringExtra("txt2")
        var txt4 = i.getStringExtra("txt3")

        val txt2 = "%,.2f".format(txt1.toString().toDouble())
        op4.text = "%,.2f".format(txt1.toString().toDouble())

        op2.text = txt3.toString()
        op3.text = txt4.toString()

        rb1.setOnClickListener {
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
    }
}