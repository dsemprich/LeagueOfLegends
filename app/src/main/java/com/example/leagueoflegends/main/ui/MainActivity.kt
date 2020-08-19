package com.example.leagueoflegends.main.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.VisibleForTesting
import com.example.leagueoflegends.R
import com.example.leagueoflegends.binding.bindingView
import com.example.leagueoflegends.databinding.ActivityMainBinding
import com.example.leagueoflegends.extensions.onTransformationStartContainer
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by bindingView(R.layout.activity_main)
    @VisibleForTesting val viewModel by viewModel<MainViewModel>()

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
