package com.example.a212605_dhiren_drnazatul_lab04.model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CheapMealViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CheapMealUiState())
    val uiState: StateFlow<CheapMealUiState> = _uiState.asStateFlow()

    val isProfileSet: Boolean
        get() = _uiState.value.name.isNotEmpty()

    fun updateProfile(name: String, email: String, budgetPerMeal: String, dietaryPreference: String) {
        _uiState.update {
            it.copy(
                name = name,
                email = email,
                budgetPerMeal = budgetPerMeal,
                dietaryPreference = dietaryPreference
            )
        }
    }

    fun setCategory(category: String) {
        _uiState.update { it.copy(selectedCategory = category) }
    }

    fun resetProfile() {
        _uiState.update { it.copy(name = "", email = "", budgetPerMeal = "", dietaryPreference = "") }
    }
}
