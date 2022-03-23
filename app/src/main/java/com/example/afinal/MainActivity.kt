package com.example.afinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btcal1.setOnClickListener {


            if (rdbt1.isChecked == false && rdbt2.isChecked == false && rdbt3.isChecked == false && rdbt4.isChecked == false && rdbt5.isChecked == false) {
                Toast.makeText(this, "กรุณาเลือกกิจกรรม", Toast.LENGTH_SHORT).show()
            } else if (radioWomen.isChecked == false && radioMen.isChecked == false) {
                Toast.makeText(this, "กรุณาเลือกเพศ", Toast.LENGTH_SHORT).show()
            } else if (h1.text.toString() == "" || a1.text.toString() == "" || w1.text.toString() == "") {
                Toast.makeText(this, "กรุณาใส่ข้อมูลให้ถูกต้อง", Toast.LENGTH_SHORT).show()
            } else {
                var txt1 = w1.text.toString().toDouble()
                var txt2 = (h1.text.toString().toDouble() * 0.01)
                var txt3 = (txt1.toDouble() / Math.pow(txt2.toDouble(), 2.0))
                var txt4 = a1.text.toString().toDouble()

                var m: Double = 0.0
                var n = 0.0
                if (radioMen.isChecked) {
                    m = (66 + (13.7 * w1.text.toString()
                        .toDouble()) + (5 * h1.text.toString().toDouble()) - (6.8 * txt4))
                } else if (radioWomen.isChecked) {
                    m = (665 + (9.6 * w1.text.toString()
                        .toDouble()) + (1.8 * h1.text.toString().toDouble()) - (4.7 * txt4))
                }

                if (rdbt1.isChecked) {
                    n = (m.toDouble() * 1.2)
                } else if (rdbt2.isChecked) {
                    n = (m.toDouble() * 1.375)
                } else if (rdbt3.isChecked) {
                    n = (m.toDouble() * 1.55)
                } else if (rdbt4.isChecked) {
                    n = (m.toDouble() * 1.725)
                } else if (rdbt5.isChecked) {
                    n = (m.toDouble() * 1.9)
                }

                val i = Intent(this, MainActivity2::class.java)
                i.putExtra("txt1", txt3.toString())
                i.putExtra("txt2", m.toInt().toString())
                i.putExtra("txt3", n.toInt().toString())
                startActivity(i)


            }

        }


        btcal2.setOnClickListener {
            RDG.clearCheck()
            radioGroup.clearCheck()
            w1.text.clear()
            h1.text.clear()
            a1.text.clear()
        }

    }


}