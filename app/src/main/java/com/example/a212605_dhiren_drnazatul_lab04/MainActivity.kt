package com.example.a212605_dhiren_drnazatul_lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.a212605_dhiren_drnazatul_lab04.ui.theme.A212605_Dhiren_DrNazatul_Lab04Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            A212605_Dhiren_DrNazatul_Lab04Theme {
                CheapMealApp()
            }
        }
    }
}
