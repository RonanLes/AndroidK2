package com.example.myapplication

import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {
    private val mTabQuestions = listOf(
        Question(R.string.question_1, true),
        Question(R.string.question_2, false),
        Question(R.string.question_3, true),
        Question(R.string.question_4, false),
        Question(R.string.question_5, true),
    )
    private var mIndexQuestion = 0

    val txtQuestionActuelle: Int
        get() = mTabQuestions[mIndexQuestion].textResId
    val  repReponseActuelle: Boolean
        get() = mTabQuestions[mIndexQuestion].answer
    fun QuestionSuivante(){
        mIndexQuestion = (mIndexQuestion + 1) % mTabQuestions.size
    }
}