package com.dino.kidsq.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StartGameViewModel : ViewModel() {

    private val _startGame = MutableLiveData<Boolean>()
    val startGame: LiveData<Boolean>
        get() = _startGame


    fun onPlay(){
        _startGame.value = true
    }

    fun onStarted(){
        _startGame.value = false
    }
}