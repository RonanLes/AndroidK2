package com.example.myapplication
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

const val EXTRA_REPONSE_AFFICHE= "com.example.myapplication.reponse_affiche"
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
        binding.btnafficheAide.setOnClickListener {vue:View ->
        val reponseCorrecte = quizViewModel.repReponseActuelle
        val intention = AideActivity.newIntent(this@MainActivity, reponseCorrecte)
        //startActivity(intention)
            demarreAide.launch(intent)
        }

    }
    private val demarreAide = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult())
    { result ->
        if (result.resultCode == RESULT_OK){
            val reponseAffichee = result.data?.getBooleanExtra(EXTRA_REPONSE_AFFICHE, false) ?: false
            quizViewModel.estAide = reponseAffichee
        }
    }
    private fun setResultReponseAffichee(reponseAffichee:Boolean){
        val intention = Intent().apply{
            putExtra(EXTRA_REPONSE_AFFICHE, reponseAffichee)
        }
        setResult(RESULT_OK, intention)
    }
    private fun majQuestion(){
        val questionTextResId = quizViewModel.txtQuestionActuelle
        binding.tvQuestion.setText(questionTextResId)
    }
    private fun checkAnswer(userAnswer:Boolean){
        val correctAnswer = quizViewModel.repReponseActuelle
       /* val messageResId = if (userAnswer == correctAnswer){
            R.string.correct_toast
        }else{
            R.string.incorrect_toast
        }*/
        val messageResId= when{
            quizViewModel.estAide -> R.string.toast_Aide
            userAnswer == correctAnswer -> R.string.correct_toast
            else -> R.string.incorrect_toast
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