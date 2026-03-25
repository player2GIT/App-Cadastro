package com.example.teste2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class Cadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        //date picker
        val datePicker = findViewById<DatePicker>(R.id.date_picker)

        val dia = datePicker.dayOfMonth
        val mes = datePicker.month+1
        val ano = datePicker.year

        val data = "%dia/%mes/%ano"

        //spinner
        val spinner = findViewById<Spinner>(R.id.spinnerTipo)

        val tipos = arrayOf("alimentação", "transporte", "lazer")

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            tipos
        )

        spinner.adapter = adapter


    }
}