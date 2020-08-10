package com.example.leagueoflegends.details.ui

import androidx.databinding.ObservableBoolean
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.leagueoflegends.details.repository.DetailRepository
import com.example.leagueoflegends.model.ChampionDetail
import kotlinx.coroutines.Dispatchers

class DetailViewModel @ViewModelInject constructor(
    private val detailRepository: DetailRepository
) : ViewModel() {

    private var championFetchingLiveData: MutableLiveData<String> = MutableLiveData()
    val championInfoLiveData: LiveData<ChampionDetail?>

    val isLoading: ObservableBoolean = ObservableBoolean(false)
    val toastLiveData: MutableLiveData<String> = MutableLiveData()

    init {
        championInfoLiveData = championFetchingLiveData.switchMap {
            isLoading.set(true)
            liveData<ChampionDetail?>(viewModelScope.coroutineContext + Dispatchers.IO) {
                emitSource(
                    detailRepository.fetchChampionsList(
                        name = it,
                        onSuccess = { isLoading.set(false) },
                        onError = { toastLiveData.postValue(it) }
                    ).asLiveData()
                )
            }
        }
    }

    fun fetchChampionInfo(name: String) {
        championFetchingLiveData.value = name
    }
}