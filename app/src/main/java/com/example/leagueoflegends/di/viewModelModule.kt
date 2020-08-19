package com.example.leagueoflegends.di

import com.example.leagueoflegends.details.ui.DetailViewModel
import com.example.leagueoflegends.main.repository.MainRepository
import com.example.leagueoflegends.main.ui.MainViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


val viewModelModule = module {

    viewModel { MainViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}