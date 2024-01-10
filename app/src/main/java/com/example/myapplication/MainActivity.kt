package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

import com.example.myapplication.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var mbtnVrai:Button
    private lateinit var mbtnFaux:Button
    private lateinit var binding: ActivityMainBinding
    private val mTabQuestions = listOf(
        Question(R.string.question_1, true),
        Question(R.string.question_2, false),
        Question(R.string.question_3, true),
        Question(R.string.question_4, false),
        Question(R.string.question_5, true),
        )
    private var mIndexQuestion = 0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnVrai.setOnClickListener {vue:View ->
            checkAnswer(true)
            majQuestion()
        }

        binding.btnFaux.setOnClickListener {vue:View ->
            checkAnswer(false)
        }

        binding.btnNext.setOnClickListener {vue:View ->
            mIndexQuestion = (mIndexQuestion + 1) % mTabQuestions.size
            majQuestion()
        }
    }
    private fun majQuestion(){
        val questionTextResId = mTabQuestions[mIndexQuestion].textResId
        binding.tvQuestion.setText(questionTextResId)
    }
private fun checkAnswer(userAnswer:Boolean){
        val correctAnswer = mTabQuestions[mIndexQuestion].answer
        val messageResId = if (userAnswer == correctAnswer){
            R.string.correct_toast
        }else{
            R.string.incorrect_toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_LONG).show()
    }
}