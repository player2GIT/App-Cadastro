package com.example.teste2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_list_view)

        val listView = findViewById<ListView>(R.id.listView)

        val editBuscar = findViewById<EditText>(R.id.editBusca)
        val btBuscar = findViewById<Button>(R.id.btBuscar)

        val listaOriginal = mutableListOf(
            "Arroz",
            "Feijão",
            "Macarrão",
            "Carne"
        )

        val listaExibida = mutableListOf<String>()
        listaExibida.addAll(listaOriginal)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            listaExibida
        )

        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            listaExibida.removeAt(position)
            adapter.notifyDataSetChanged()
        }

        btBuscar.setOnClickListener {

            val texto = editBuscar.text.toString().lowercase()

            listaExibida.clear()

            if (texto.isEmpty()) {
                listaExibida.addAll(listaOriginal)
            } else {
                for (item in listaOriginal) {
                    if (item.lowercase().contains(texto)) {
                        listaExibida.add(item)
                    }
                }
            }

            adapter.notifyDataSetChanged()
        }

        val editItem = findViewById<EditText>(R.id.editItem)
        val btAdicionar = findViewById<Button>(R.id.btAdicionar)

        btAdicionar.setOnClickListener {

            val novoItem = editItem.text.toString().trim()

            // vazio
            if (novoItem.isEmpty()) {
                editItem.error = "digite algo!"
                return@setOnClickListener
            }

            // repetido
            if (listaOriginal.contains(novoItem)) {
                editItem.error = "item já existe!"
                return@setOnClickListener
            }

            // valido
            listaOriginal.add(novoItem)
            listaExibida.add(novoItem)

            adapter.notifyDataSetChanged()

            editItem.text.clear()
        }

        val btLimpar = findViewById<Button>(R.id.btLimpar)
        btLimpar.setOnClickListener {

            listaOriginal.clear()
            listaExibida.clear()

            adapter.notifyDataSetChanged()
        }
    }
}