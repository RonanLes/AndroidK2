package com.example.myapplication
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding


private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val quizViewModel: QuizViewModel by viewModels()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "Current question index: $quizViewModel")

        binding.btnVrai.setOnClickListener {vue:View ->
            checkAnswer(true)
            majQuestion()
        }

        binding.btnFaux.setOnClickListener {vue:View ->
            checkAnswer(false)
        }
        binding.btnNext.setOnClickListener {vue:View ->
            quizViewModel.QuestionSuivante()
            majQuestion()
        }

    }
    private fun majQuestion(){
        val questionTextResId = quizViewModel.txtQuestionActuelle
        binding.tvQuestion.setText(questionTextResId)
    }
    private fun checkAnswer(userAnswer:Boolean){
        val correctAnswer = quizViewModel.repReponseActuelle
        val messageResId = if (userAnswer == correctAnswer){
            R.string.correct_toast
        }else{
            R.string.incorrect_toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }
    override fun onStart(){
        super.onStart()
        Log.d(TAG, "onStart called")
    }
    override fun onResume(){
        super.onResume()
        Log.d(TAG, "onResume called")
    }
    override fun onPause(){
        super.onPause()
        Log.d(TAG, "onPause called")
    }
    override fun onStop(){
        super.onStop()
        Log.d(TAG, "onStop called")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.d(TAG, "onDestroy called")
    }
}