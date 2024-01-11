package com.example.myapplication

import androidx.lifecycle.SavedStateHandle
import org.junit.jupiter.api.Assertions.*
import org.junit.Test
import androidx.lifecycle.createSavedStateHandle

    class QuizViewModelTest{
        @Test
        fun FournitBonTxtQuestion(){
            val SavedStateHandle = SavedStateHandle()
            val QuizViewModel = QuizViewModel(SavedStateHandle)
            assertEquals(R.string.question_1, QuizViewModel.txtQuestionActuelle)
        }
    }