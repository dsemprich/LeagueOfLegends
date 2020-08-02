package com.example.leagueoflegends.network

import com.example.leagueoflegends.model.Champions
import com.google.gson.Gson
import org.junit.Assert.*
import org.junit.Test
import utils.MockResponseFileReader

class JsonResponse  {

    private val champions = MockResponseFileReader("get_champions.json")

    @Test
    fun `champions first item is Aatrox`(){
        val data: Champions = Gson().fromJson(champions.content, Champions::class.java)
        assertEquals(data.data.keys.toList()[0], "Aatrox")
    }
}