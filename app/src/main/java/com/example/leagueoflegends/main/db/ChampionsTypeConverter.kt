package com.example.leagueoflegends.main.db

import androidx.room.TypeConverter
import com.example.leagueoflegends.model.Champion
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

open class ChampionsTypeConverter {

    @TypeConverter
    fun fromString(value: String): List<String> {
        val mapType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, mapType)
    }

    @TypeConverter
    fun fromList(list: List<String>):String {
        return Gson().toJson(list)
    }
}