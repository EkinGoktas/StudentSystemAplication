package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class menuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nothesaplabtn : Button = findViewById(R.id.nothesaplabtn)
        val heapmakinesibtn : Button = findViewById(R.id.heapmakinesibtn)

        nothesaplabtn.setOnClickListener {
            val intent = Intent(this, VizeNotHesaplama::class.java)
            startActivity(intent)
        }
        heapmakinesibtn.setOnClickListener {
            val intent = Intent(this, HesapMakinesi::class.java)
            startActivity(intent)
        }
    }
}