package com.example.leagueoflegends.main.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.asLiveData
import com.example.leagueoflegends.main.db.ChampionsDao
import com.example.leagueoflegends.model.Champion
import com.example.leagueoflegends.model.Champions
import com.example.leagueoflegends.network.LolService
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import retrofit2.Response
import com.example.leagueoflegends.util.MockUtil.mockChampionsMap

@ExperimentalCoroutinesApi
class MainRepositoryTest {

    private lateinit var repository: MainRepository
    private val service: LolService = mockk()
    private val championsDao: ChampionsDao = mockk()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        repository = MainRepository(service, championsDao)
    }

    @Test
    fun `fetch ChampionsList from Remote`() = runBlocking {
        val mockData = mockk<Response<Champions>>(relaxed = true).apply {
            every { isSuccessful } returns true
            every { body()?.data } returns mockChampionsMap()
        }
        coEvery { service.fetchChampions(any()) } returns mockData
        coEvery { championsDao.getChampionsList() } returns emptyList()
        val  response = repository.fetchChampionsList()
        response.collect {
            assertEquals(it[0].name,"Aatrox")
        }
    }

    @Test
    fun `fetch championsList from Database`() = runBlocking {
        val mockData = mockChampionsMap().map { it.value }
        coEvery { championsDao.getChampionsList() } returns mockData
        val  response = repository.fetchChampionsList()
        response.collect {
            assertEquals(it[0].name,"Aatrox")
        }
    }
}