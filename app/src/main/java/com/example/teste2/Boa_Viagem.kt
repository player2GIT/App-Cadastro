package com.example.teste2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Boa_Viagem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_boa_viagem)
        val buttonNovoGasto = findViewById<Button>(R.id.Gasto)
        buttonNovoGasto.setOnClickListener {
            val intentSegTela = Intent(this, Cadastro::class.java)
            startActivity(intentSegTela)
        }

        val buttonNovaViagem = findViewById<Button>(R.id.btNovaViagem)
        buttonNovaViagem.setOnClickListener {
            val intentTerceiraTela = Intent(this, ListViewActivity::class.java)
            startActivity(intentTerceiraTela)
        }
    }
}