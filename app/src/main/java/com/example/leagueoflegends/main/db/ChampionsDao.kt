package com.example.leagueoflegends.main.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.leagueoflegends.model.Champion
import com.example.leagueoflegends.model.Champions

@Dao
interface ChampionsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChampionsList(championsList: List<Champion>)

    @Query("SELECT * FROM Champion ")
    suspend fun getChampionsList(): List<Champion>
}