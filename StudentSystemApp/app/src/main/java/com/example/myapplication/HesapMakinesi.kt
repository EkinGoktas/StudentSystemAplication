package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HesapMakinesi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hesap_makinesi)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val zeroButton = findViewById<Button>(R.id.button0)
        val oneButton = findViewById<Button>(R.id.button1)
        val twoButton = findViewById<Button>(R.id.button2)
        val threeButton = findViewById<Button>(R.id.button3)
        val fourButton = findViewById<Button>(R.id.button4)
        val fiveButton = findViewById<Button>(R.id.button5)
        val sixButton = findViewById<Button>(R.id.button6)
        val sevenButton = findViewById<Button>(R.id.button7)
        val eightButton = findViewById<Button>(R.id.button8)
        val nineButton = findViewById<Button>(R.id.button9)
        val pointButton = findViewById<Button>(R.id.buttonNokta)
        val calculateButton = findViewById<Button>(R.id.esittir)
        val sifr=findViewById<Button>(R.id.sifirla)
        val btnGeri = findViewById<Button>(R.id.btnGeri)
        val eksi = findViewById<Button>(R.id.eksi)
        val arti = findViewById<Button>(R.id.artı)
        val carpi = findViewById<Button>(R.id.carpi)
        val bolu = findViewById<Button>(R.id.bolu)
        val sonuctTxT = findViewById<TextView>(R.id.sonuctv)
        val islemTxT = findViewById<TextView>(R.id.islemtv)

        var currentNum = ""
        var num1 = 0
        var num2 = 0
        var sonuc = 0

        btnGeri.setOnClickListener {
            val intent = Intent(this, menuActivity::class.java)
            startActivity(intent)
        }

        pointButton.setOnClickListener {
            if (!currentNum.contains(".")) {
                currentNum = if (currentNum.isEmpty()) "0." else currentNum + "."
                islemTxT.text = islemTxT.text.toString() + "."
                sonuctTxT.text = currentNum
            }
        }

        sifr.setOnClickListener {
            currentNum = ""
            sonuctTxT.text = ""
            islemTxT.text = ""
        }

        zeroButton.setOnClickListener {
            currentNum = sonuctTxT.text.toString() + "0"
            islemTxT.text = islemTxT.text.toString() + "0"
            sonuctTxT.text = currentNum
        }
        oneButton.setOnClickListener {
            currentNum = sonuctTxT.text.toString() + "1"
            islemTxT.text = islemTxT.text.toString() + "1"
            sonuctTxT.text = currentNum
        }
        twoButton.setOnClickListener {
            currentNum = sonuctTxT.text.toString() + "2"
            islemTxT.text = islemTxT.text.toString() + "2"
            sonuctTxT.text = currentNum
        }
        threeButton.setOnClickListener {
            currentNum = sonuctTxT.text.toString() + "3"
            islemTxT.text = islemTxT.text.toString() + "3"
            sonuctTxT.text = currentNum
        }
        fourButton.setOnClickListener {
            currentNum = sonuctTxT.text.toString() + "4"
            islemTxT.text = islemTxT.text.toString() + "4"
            sonuctTxT.text = currentNum
        }
        fiveButton.setOnClickListener {
            currentNum = sonuctTxT.text.toString() + "5"
            islemTxT.text = islemTxT.text.toString() + "5"
            sonuctTxT.text = currentNum
        }
        sixButton.setOnClickListener {
            currentNum = sonuctTxT.text.toString() + "6"
            islemTxT.text = islemTxT.text.toString() + "6"
            sonuctTxT.text = currentNum
        }
        sevenButton.setOnClickListener {
            currentNum = sonuctTxT.text.toString() + "7"
            islemTxT.text = islemTxT.text.toString() + "7"
            sonuctTxT.text = currentNum
        }
        eightButton.setOnClickListener {
            currentNum = sonuctTxT.text.toString() + "8"
            islemTxT.text = islemTxT.text.toString() + "8"
            sonuctTxT.text = currentNum
        }
        nineButton.setOnClickListener {
            currentNum = sonuctTxT.text.toString() + "9"
            islemTxT.text = islemTxT.text.toString() + "9"
            sonuctTxT.text = currentNum
        }
        arti.setOnClickListener {
            islemTxT.text = islemTxT.text.toString() + "+"
            num1 = currentNum.toInt()
            sonuctTxT.text = ""
            currentNum = ""
        }
        eksi.setOnClickListener {
            num1 = currentNum.toInt()
            islemTxT.text = islemTxT.text.toString() + "-"
            sonuctTxT.text = ""
            currentNum = ""
        }
        carpi.setOnClickListener {
            islemTxT.text = islemTxT.text.toString() + "x"
            num1 = currentNum.toInt()
            sonuctTxT.text = ""
            currentNum = ""
        }
        bolu.setOnClickListener {
            islemTxT.text = islemTxT.text.toString() + "/"
            num1 = currentNum.toInt()
            sonuctTxT.text = ""
            currentNum = ""
        }
        calculateButton.setOnClickListener {
            if (arti.isEnabled) {
                num2 = currentNum.toInt()
                sonuc = num1 + num2
                sonuctTxT.text = sonuc.toString()
                num1 = 0
                num2 = 0
                currentNum = ""
            }
            else if (eksi.isEnabled) {
                num2 = currentNum.toInt()
                sonuc = num1 - num2
                sonuctTxT.text = sonuc.toString()
                num1 = 0
                num2 = 0
                currentNum = ""
            }
            else if (carpi.isEnabled) {
                num2 = currentNum.toInt()
                sonuc = num1 * num2
                sonuctTxT.text = sonuc.toString()
                num1 = 0
                num2 = 0
                currentNum = ""
            }
            else if (bolu.isEnabled) {
                num2 = currentNum.toInt()
                sonuc = num1 / num2
                sonuctTxT.text = sonuc.toString()
                num1 = 0
                num2 = 0
                currentNum = ""
            }
        }

    }

}