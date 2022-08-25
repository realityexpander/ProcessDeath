package com.realityexpander.processdeath

import android.os.Parcelable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(val name: String, val country: String) : Parcelable

class MainViewModel(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    var user by mutableStateOf(
        savedStateHandle["user_key"] ?: User("", "")
        )

    var counter by mutableStateOf(savedStateHandle["counter_key"] ?: 0)
        private set

    fun onCountClick() {
        counter++

        user = User("John", "USA $counter")

        // must save stateHandle after each change
        savedStateHandle["counter_key"] = counter
        savedStateHandle["user_key"] = user
    }
}