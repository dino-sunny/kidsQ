package com.dino.kidsq.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PlayerDao {
    @Insert
    fun insert(player: Player)

    @Update
    fun update(player: Player)

    @Query("SELECT * FROM player_table ORDER BY playerId DESC LIMIT 1" )
    fun getHighScore(): Player?

    @Query("SELECT * FROM player_table ORDER BY playerId DESC LIMIT 1")
    fun getPlayer(): Player?

}