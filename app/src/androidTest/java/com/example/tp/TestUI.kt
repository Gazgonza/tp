package com.example.tp

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner


import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class TestUI {

    private  lateinit var viewModel: MainViewModel

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)



    @Test
    fun testButtonClick (){
        // Acción botón
        Espresso.onView(ViewMatchers.withId(R.id.comparar))
            .perform(ViewActions.click())

        // hay datos en boton?
        Espresso.onView(ViewMatchers.withId(R.id.visor))
            .check(ViewAssertions.matches(ViewMatchers.withText("Faltan ambos textos")))
        viewModel.compareWords("hola","hola")


    }
}
