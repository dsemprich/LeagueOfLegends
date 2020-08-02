package com.example.leagueoflegends.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.leagueoflegends.main.db.ChampionsDao
import com.example.leagueoflegends.main.db.ChampionsTypeConverter
import com.example.leagueoflegends.model.Champion
import com.example.leagueoflegends.model.Champions

@Database(entities = [Champion::class], version = 1, exportSchema = true)
@TypeConverters(ChampionsTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun championsDao(): ChampionsDao
}