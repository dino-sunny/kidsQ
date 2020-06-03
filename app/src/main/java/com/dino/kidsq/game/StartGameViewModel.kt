package com.dino.kidsq.game

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dino.kidsq.database.Player
import com.dino.kidsq.database.PlayerDao
import kotlinx.coroutines.*

class StartGameViewModel(val database: PlayerDao, application: Application) :
    AndroidViewModel(application) {

    private val _startGame = MutableLiveData<Boolean>()
    val startGame: LiveData<Boolean>
        get() = _startGame

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main +viewModelJob)
    private  var player = MutableLiveData<Player?>()

    init {
        initializePlayer()
    }

    private fun initializePlayer() {
        uiScope.launch {
            player.value = getPlayerFromDatabase()
        }
    }

    private suspend fun getPlayerFromDatabase() : Player? {
        return withContext(Dispatchers.IO){
            var player = database.getPlayer()
            player
        }
    }

    fun onPlay(){
        _startGame.value = true
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}