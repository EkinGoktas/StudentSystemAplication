package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class VizeNotHesaplama : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_vize_not_hesaplama)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val hesaplaBtn : Button = findViewById(R.id.btnHesap)
        val btnGeri : Button = findViewById(R.id.btnGeri)


        hesaplaBtn.setOnClickListener {
            var ort = notlarıAl()
            Toast.makeText(this, "Ortalamanız : " + ort, Toast.LENGTH_LONG).show()
        }
        btnGeri.setOnClickListener {
            val intent = Intent(this, menuActivity::class.java)
            startActivity(intent)
        }
    }

    private fun notHesapla(vizeNot: Double, finalNot: Double, projeNot: Double, katilimNot: Double): Double {
        var vize = vizeNot * 0.3
        var finall = finalNot * 0.4
        var proje = projeNot * 0.2
        var katilim = katilimNot * 0.1
        var ortalama = vize + finall + proje + katilim
        return ortalama
    }
    private fun notlarıAl(): Double {
        val etVize : EditText = findViewById(R.id.etVize)
        val etFinal : EditText = findViewById(R.id.etFinalNot)
        val etProje : EditText = findViewById(R.id.etProjeNot)
        val etKatilim : EditText = findViewById(R.id.etKatilimNot)
        var vizeNot = etVize.text.toString().toDouble()
        var finalNot = etFinal.text.toString().toDouble()
        var projeNot = etProje.text.toString().toDouble()
        var katilimNot = etKatilim.text.toString().toDouble()
        var ort = notHesapla(vizeNot, finalNot, projeNot, katilimNot)
        return ort
    }
}