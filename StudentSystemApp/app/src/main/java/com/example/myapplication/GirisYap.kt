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

class GirisYap : AppCompatActivity() {
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_giris_yap)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val signup_btn = findViewById<Button>(R.id.signup_btn)
        val login_btn = findViewById<Button>(R.id.login_btn)
        val kullaniciAdi = findViewById<EditText>(R.id.username_input)
        val sifre = findViewById<EditText>(R.id.password_input)

        databaseHelper = DatabaseHelper(this)

        signup_btn.setOnClickListener {
            val intent = Intent(this, UyeOl::class.java)
            startActivity(intent)
        }
        login_btn.setOnClickListener {
            var kayitli = databaseHelper.validateUser(kullaniciAdi.text.toString(), sifre.text.toString())
            if (kayitli) {
                val intent = Intent(this, menuActivity::class.java)
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "Hatalı kullanıcı adı veya şifre", Toast.LENGTH_LONG).show()
                kullaniciAdi.setText("")
                sifre.setText("")
            }
        }
    }
}