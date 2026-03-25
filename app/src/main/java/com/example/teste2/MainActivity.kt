package com.example.teste2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.R.attr.button
import android.content.Intent
import android.widget.Button
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, Boa_Viagem::class.java)
            startActivity(intent)
        }
    }
}