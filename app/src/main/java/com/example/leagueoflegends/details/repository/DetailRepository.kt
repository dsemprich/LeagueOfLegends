package com.example.leagueoflegends.details.repository

import com.example.leagueoflegends.details.db.ChampionInfoDao
import com.example.leagueoflegends.extensions.supportedLanguage
import com.example.leagueoflegends.network.LolService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.*

class DetailRepository  constructor(
    private val lolService: LolService,
    private val championInfoDao: ChampionInfoDao
) {
    suspend fun fetchChampionsList(
        name: String,
        onSuccess: () -> Unit = {},
        onError: (String) -> Unit = {}
    ) = flow {
        var champion = championInfoDao.getChampionInfo(name)
        if (champion == null) {
            val response = lolService.fetchChampionInfo(Locale.getDefault().supportedLanguage(), name)
            if (response.isSuccessful) {
                response.body()?.let {
                    champion = it.data.map { it.value }[0]
                    championInfoDao.insertChampionInfo(champion!!)
                    emit(champion)
                    onSuccess()
                }
            } else {
                onError(response.message())
            }
        } else {
            emit(champion)
            onSuccess()
        }
    }.flowOn(Dispatchers.IO)
}
