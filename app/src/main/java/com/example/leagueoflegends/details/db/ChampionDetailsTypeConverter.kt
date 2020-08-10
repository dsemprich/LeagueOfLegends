package com.example.leagueoflegends.details.db

import androidx.room.TypeConverter
import com.example.leagueoflegends.model.Champion
import com.example.leagueoflegends.model.ChampionDetail
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

open class ChampionDetailsTypeConverter {

    @TypeConverter
    fun fromPassiveString(value: String): ChampionDetail.Passive {
        val mapType = object : TypeToken<ChampionDetail.Passive>() {}.type
        return Gson().fromJson(value, mapType)
    }

    @TypeConverter
    fun fromImage(passive: ChampionDetail.Passive):String {
        return Gson().toJson(passive)
    }

    @TypeConverter
    fun fromRecommendedListString(value: String): List<ChampionDetail.Recommended> {
        val mapType = object : TypeToken<List<ChampionDetail.Recommended>>() {}.type
        return Gson().fromJson(value, mapType)
    }

    @TypeConverter
    fun fromRecommendedList(recommended: List<ChampionDetail.Recommended>):String {
        return Gson().toJson(recommended)
    }

    @TypeConverter
    fun fromSkinListString(value: String): List<ChampionDetail.Skin> {
        val mapType = object : TypeToken<List<ChampionDetail.Skin>>() {}.type
        return Gson().fromJson(value, mapType)
    }

    @TypeConverter
    fun fromSkinList(skin: List<ChampionDetail.Skin>):String {
        return Gson().toJson(skin)
    }

    @TypeConverter
    fun fromSpellListString(value: String): List<ChampionDetail.Spell> {
        val mapType = object : TypeToken<List<ChampionDetail.Spell>>() {}.type
        return Gson().fromJson(value, mapType)
    }

    @TypeConverter
    fun fromSpellList(spell: List<ChampionDetail.Spell>):String {
        return Gson().toJson(spell)
    }

    @TypeConverter
    fun fromStatsString(value: String): ChampionDetail.Stats {
        val mapType = object : TypeToken<ChampionDetail.Stats>() {}.type
        return Gson().fromJson(value, mapType)
    }

    @TypeConverter
    fun fromStats(stats: ChampionDetail.Stats):String {
        return Gson().toJson(stats)
    }
}