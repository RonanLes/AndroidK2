package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityAideBinding

class AideActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAideBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAideBinding.inflate(layoutInflater)
        setContentView(binding.root)
            }
}