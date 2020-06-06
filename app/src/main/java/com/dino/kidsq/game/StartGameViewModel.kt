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

    private val topPlayer = MutableLiveData<Player>()
    val highScore : LiveData<Player>
    get() = topPlayer

    private var _result = MutableLiveData<String>()
    val userName: LiveData<String>
        get() = _result

    init {
        initializePlayer()
        getTopper()
    }

    fun onUserNameChanged(userKey: CharSequence, start: Int, before: Int, count: Int) {
           _result.value = userKey.toString()
    }

//    fun update(result: String){
//        _result.value = result
//    }

    private fun getTopper() {
        uiScope.launch {
            topPlayer.value = getTopPlayer()
        }
    }

    private suspend fun getTopPlayer(): Player? {
        return withContext(Dispatchers.IO){
            database.getHighScore()
        }
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

    fun onStartGame(){
        uiScope.launch {
            val newPayer = Player()
            newPayer.userName = _result.value.toString()
            insert(newPayer)
            player.value = getPlayerFromDatabase()
        }
        _startGame.value = !_result.value.isNullOrEmpty()
    }
    private suspend fun insert(player: Player){
        withContext(Dispatchers.IO){
            database.insert(player)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}