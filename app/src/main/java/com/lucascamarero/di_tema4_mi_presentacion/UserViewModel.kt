package com.lucascamarero.di_tema4_mi_presentacion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    // Estado compartido entre pantallas
    var numero by mutableStateOf(0)
        private set

    fun setNum(num: Int) {
        numero = num
    }
}