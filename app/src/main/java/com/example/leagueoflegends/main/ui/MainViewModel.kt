package com.example.leagueoflegends.main.ui

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.*
import com.example.leagueoflegends.main.repository.MainRepository
import com.example.leagueoflegends.model.Champion
import kotlinx.coroutines.Dispatchers

class MainViewModel  constructor(
    private val mainRepository: MainRepository
) : ViewModel() {
    val isLoading: ObservableBoolean = ObservableBoolean(false)
    val toastLiveData: MutableLiveData<String> = MutableLiveData()

    private var championsFetchingLiveData: MutableLiveData<Int> = MutableLiveData()
    val championListLiveData: LiveData<List<Champion>>

    init {
        championListLiveData = championsFetchingLiveData.switchMap {
            isLoading.set(true)
            liveData<List<Champion>>(viewModelScope.coroutineContext + Dispatchers.IO) {
                emitSource(
                    mainRepository.fetchChampionsList(
                        onSuccess = { isLoading.set(false) },
                        onError = { toastLiveData.postValue(it) }
                    ).asLiveData()
                )
            }
        }
    }

    fun fetchChampionsList() {
        championsFetchingLiveData.value = 0
    }
}
