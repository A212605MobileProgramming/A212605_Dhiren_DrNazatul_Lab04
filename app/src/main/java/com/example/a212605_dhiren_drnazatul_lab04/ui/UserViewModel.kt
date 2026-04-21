package com.example.a212605_dhiren_drnazatul_lab04.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.a212605_dhiren_drnazatul_lab04.model.UserProfile

class UserViewModel : ViewModel() {

    var userProfile by mutableStateOf(UserProfile())
        private set

    val isProfileSet: Boolean
        get() = userProfile.name.isNotEmpty()

    fun updateProfile(profile: UserProfile) {
        userProfile = profile
    }

    fun clearProfile() {
        userProfile = UserProfile()
    }
}
