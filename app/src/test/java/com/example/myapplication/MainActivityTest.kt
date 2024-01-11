package com.example.myapplication

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private lateinit var scenario: ActivityScenario<MainActivity>
    @BeforeEach
    fun setUp() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @AfterEach
    fun tearDown() {
        scenario.close()
    }
    @Test
    fun afficheQuestionLancement(){
        onView(withId(R.id.tv_question)).check(matches(withText(R.string.question_1)))
    }
    fun affcheQuestionClickBoutonSuivant(){
        onView(withId(R.id.btnNext)).perform(click())
        onView(withId(R.id.tv_question)).check(matches(withText(R.string.question_2)))
    }
}