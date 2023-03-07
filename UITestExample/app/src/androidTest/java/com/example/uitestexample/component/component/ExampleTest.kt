package com.example.uitestexample.component.component

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.uitestexample.component.MainScreen
import org.junit.Rule
import org.junit.Test

class ExampleTest {

    @get:Rule
    val testRule = createComposeRule()

    @Test
    fun exampleTest(){
        testRule.setContent {
            MainScreen()
        }
        testRule.onNodeWithTag("textOne").performTextInput("titi")
        testRule.onNodeWithText("Button").performClick()
        testRule.onNodeWithTag("textFinal").assertTextEquals("titi")
    }

}