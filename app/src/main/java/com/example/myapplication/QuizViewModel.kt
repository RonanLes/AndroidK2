package com.example.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.SavedStateHandle

const val INDEX_ACTUEl_KEY = "INDEX_ACTUAl_KEY"
class QuizViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    private val mTabQuestions = listOf(
        Question(R.string.question_1, true),
        Question(R.string.question_2, false),
        Question(R.string.question_3, true),
        Question(R.string.question_4, false),
        Question(R.string.question_5, true),
    )
    private var mIndexQuestion = 0

    private var mIndexActuel : Int
    get() = savedStateHandle.get<Int>(INDEX_ACTUEl_KEY) ?: 0
        set(value) = savedStateHandle.set(INDEX_ACTUEl_KEY, value)
    val txtQuestionActuelle: Int
        get() = mTabQuestions[mIndexQuestion].textResId
    val  repReponseActuelle: Boolean
        get() = mTabQuestions[mIndexQuestion].answer
    fun QuestionSuivante(){
        mIndexQuestion = (mIndexQuestion + 1) % mTabQuestions.size
    }
}