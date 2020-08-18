package com.example.leagueoflegends.main.ui

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.activity.viewModels
import androidx.annotation.VisibleForTesting
import com.example.leagueoflegends.R
import com.example.leagueoflegends.binding.bindingView
import com.example.leagueoflegends.databinding.ActivityMainBinding
import com.example.leagueoflegends.extensions.onTransformationStartContainer
import com.google.android.material.transition.MaterialContainerTransformSharedElementCallback
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by bindingView(R.layout.activity_main)
    @VisibleForTesting val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        onTransformationStartContainer()
        super.onCreate(savedInstanceState)
        binding.apply {
            lifecycleOwner = this@MainActivity
            adapter = ChampionsAdapter()
            vm = viewModel.apply {
                fetchChampionsList()
            }
        }
    }
}
