package com.example.leagueoflegends.main.repository

import com.example.leagueoflegends.main.db.ChampionsDao
import com.example.leagueoflegends.network.LolService
import kotlinx.coroutines.flow.flow
import java.util.*
import javax.inject.Inject

class MainRepository  @Inject constructor(
    private val lolService: LolService,
    private val championsDao: ChampionsDao
) {

//    suspend fun fetchChampionsList(
//        onSuccess: () -> Unit,
//        onError: (String) -> Unit
//    ) = flow {
//        var champions = championsDao.getChampionsList()
//        if (champions.isEmpty()) {
//            val response = lolService.fetchChampions(Locale.getDefault().)
//        }
//    }

}