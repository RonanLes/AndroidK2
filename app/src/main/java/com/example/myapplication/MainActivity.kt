package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var mbtnVrai:Button
    private lateinit var mbtnFaux:Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mbtnVrai = findViewById(R.id.btnVrai)
        mbtnFaux = findViewById(R.id.btnFaux)


        mbtnVrai.setOnClickListener {vue:View ->
            Toast.makeText(this, "Vrai", Toast.LENGTH_LONG).show()
        }
        mbtnFaux.setOnClickListener {vue:View ->
            Toast.makeText(this, "Faux", Toast.LENGTH_LONG).show()        }
    }
}