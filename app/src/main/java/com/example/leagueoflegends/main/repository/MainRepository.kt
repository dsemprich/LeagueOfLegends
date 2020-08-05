package com.example.leagueoflegends.main.repository

import com.example.leagueoflegends.extensions.supportedLanguage
import com.example.leagueoflegends.main.db.ChampionsDao
import com.example.leagueoflegends.network.LolService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.*
import javax.inject.Inject

class MainRepository  @Inject constructor(
    private val lolService: LolService,
    private val championsDao: ChampionsDao
) {
    suspend fun fetchChampionsList(
        onSuccess: () -> Unit = {},
        onError: (String) -> Unit = {}
    ) = flow {
        var champions = championsDao.getChampionsList()
        if (champions.isEmpty()) {
            val response = lolService.fetchChampions(Locale.getDefault().supportedLanguage())
            if (response.isSuccessful) {
                response.body()?.let {
                    champions = it.data.map { it.value }
                    championsDao.insertChampionsList(champions)
                    emit(champions)
                    onSuccess()
                }
            } else {
                onError(response.message())
            }
        } else {
            emit(champions)
            onSuccess()
        }
    }.flowOn(Dispatchers.IO)
}