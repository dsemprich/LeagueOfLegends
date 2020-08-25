package com.example.leagueoflegends.network

import com.example.leagueoflegends.model.ChampionInfo
import com.example.leagueoflegends.model.Champions
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface LolService {
    @GET("data/{locale}/champion.json")
    suspend fun fetchChampions(@Path("locale") locale: String): Response<Champions>

    @GET("data/{locale}/champion/{name}.json")
    suspend fun fetchChampionInfo(
        @Path("locale") locale: String,
        @Path("name") name: String
    ): Response<ChampionInfo>
}