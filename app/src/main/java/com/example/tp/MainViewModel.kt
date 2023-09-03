package com.example.tp

import android.app.Application
import android.media.MediaPlayer
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val _result = MutableLiveData<String>()
    val result: LiveData<String> = _result

    private lateinit var mediaPlayer: MediaPlayer

    fun compareWords(textoN1: String, textoN2: String): String {
        val resultadoText = when {
            textoN1.isEmpty() && textoN2.isEmpty() -> {
                "Faltan ambos textos"
            }
            textoN1.isEmpty() || textoN2.isEmpty() -> {
                "Falta un texto"
            }
            textoN1 == textoN2 -> {
                "Texto similales"
            }
            else -> {
                "Textos distintos"
            }
        }

        _result.value = resultadoText
        return resultadoText
    }
}