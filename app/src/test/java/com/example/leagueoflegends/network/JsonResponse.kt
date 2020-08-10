package com.example.leagueoflegends.network

import android.os.FileUtils
import com.example.leagueoflegends.model.ChampionDetail
import com.example.leagueoflegends.model.ChampionInfo
import com.example.leagueoflegends.model.Champions
import com.google.common.io.MoreFiles.listFiles
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.junit.Assert.*
import org.junit.Test
import utils.MockResponseFileReader
import java.io.File
import java.io.InputStreamReader
import java.nio.file.Path

class JsonResponse  {

    @Test
    fun `champions first item is Aatrox`(){
        val champions = MockResponseFileReader("/api/get_champions.json")
        val data: Champions = Gson().fromJson(champions.content, Champions::class.java)
        assertEquals(data.data.keys.toList()[0], "Aatrox")
    }

    @Test

    fun `parse champion detail json`(){
        val championsInfo = MockResponseFileReader("/api/get_championsInfo.json")
        val data: ChampionInfo = Gson().fromJson(championsInfo.content, ChampionInfo::class.java)
        assertEquals(data.data.map { it.value }[0].id, "Aatrox")
    }


}