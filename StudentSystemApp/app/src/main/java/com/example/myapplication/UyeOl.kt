package com.example.myapplication

import DatabaseHelper
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UyeOl : AppCompatActivity() {
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_uye_ol)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val uyeolbtn : Button = findViewById(R.id.uyeOlbtn)
        val geribtn : Button = findViewById(R.id.geribtn)
        val etKullaniciAdi : EditText = findViewById(R.id.etKullaniciAdi)
        val etSifre : EditText = findViewById(R.id.etSifre)

        databaseHelper = DatabaseHelper(this)

        geribtn.setOnClickListener {
            val intent = Intent(this, GirisYap::class.java)
            startActivity(intent)
        }
        uyeolbtn.setOnClickListener {
            databaseHelper.addUser(etKullaniciAdi.text.toString(), etSifre.text.toString())
            Toast.makeText(this, "Kaydınız Başarıyla Oluşturuldu!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}