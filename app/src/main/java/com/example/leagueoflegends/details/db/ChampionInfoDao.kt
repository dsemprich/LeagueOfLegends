package com.example.leagueoflegends.details.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.leagueoflegends.model.ChampionDetail
import com.example.leagueoflegends.model.ChampionInfo

@Dao
interface ChampionInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChampionInfo(championDetail: ChampionDetail)

    @Query("SELECT * FROM ChampionDetail WHERE name = :name_")
    suspend fun getChampionInfo(name_: String): ChampionDetail?
}