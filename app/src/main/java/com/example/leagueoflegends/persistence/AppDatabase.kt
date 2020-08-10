package com.example.leagueoflegends.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.leagueoflegends.details.db.ChampionDetailsTypeConverter
import com.example.leagueoflegends.details.db.ChampionInfoDao
import com.example.leagueoflegends.main.db.ChampionsDao
import com.example.leagueoflegends.main.db.ChampionsTypeConverter
import com.example.leagueoflegends.model.Champion
import com.example.leagueoflegends.model.ChampionDetail
import com.example.leagueoflegends.model.Champions

@Database(entities = [Champion::class, ChampionDetail::class], version = 2, exportSchema = true)
@TypeConverters(ChampionsTypeConverter::class, ChampionDetailsTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun championsDao(): ChampionsDao
    abstract fun championsInfoDao(): ChampionInfoDao
}