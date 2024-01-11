package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityAideBinding
private const val EXTRA_REPONSE_VRAIE = "com.example.myapplication.reponse_vraie"
class AideActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAideBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAideBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var reponseCorrecte = intent.getBooleanExtra(EXTRA_REPONSE_VRAIE, false)
            }
    companion object{
        fun newIntent(packageContext: MainActivity, reponseCorrecte:Boolean):Intent{
            return Intent(packageContext, AideActivity::class.java).apply{
                putExtra(EXTRA_REPONSE_VRAIE, reponseCorrecte)
            }
        }
    }
}
