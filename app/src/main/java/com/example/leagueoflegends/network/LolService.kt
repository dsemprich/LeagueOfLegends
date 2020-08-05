package com.example.leagueoflegends.network

import com.example.leagueoflegends.model.Champions
import com.skydoves.sandwich.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface LolService {
    @GET("data/{locale}/champion.json")
    suspend fun fetchChampions(@Path("locale") locale: String): Response<Champions>
}