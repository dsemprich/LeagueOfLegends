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

    @TypeConverter
    fun fromImageString(value: String): Champion.Image {
        val mapType = object : TypeToken<Champion.Image>() {}.type
        return Gson().fromJson(value, mapType)
    }

    @TypeConverter
    fun fromImage(image: Champion.Image):String {
        return Gson().toJson(image)
    }

    @TypeConverter
    fun fromInfoString(value: String): Champion.Info {
        val mapType = object : TypeToken<Champion.Info>() {}.type
        return Gson().fromJson(value, mapType)
    }

    @TypeConverter
    fun fromInfo(info: Champion.Info):String {
        return Gson().toJson(info)
    }
}