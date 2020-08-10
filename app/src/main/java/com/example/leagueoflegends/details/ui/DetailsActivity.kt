package com.example.leagueoflegends.details.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.leagueoflegends.R
import com.example.leagueoflegends.binding.bindingView
import com.example.leagueoflegends.databinding.ActivityDetailsBinding
import com.example.leagueoflegends.extensions.onTransformationEndContainerApplyParams
import com.example.leagueoflegends.model.Champion
import com.skydoves.transformationlayout.TransformationCompat
import com.skydoves.transformationlayout.TransformationLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    private val binding: ActivityDetailsBinding by bindingView(R.layout.activity_details)
    private val viewModel: DetailViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        onTransformationEndContainerApplyParams()
        super.onCreate(savedInstanceState)
        val championItem: Champion = requireNotNull(intent.getParcelableExtra(EXTRA_CHAMPION))
        binding.apply {
            champion = championItem
            lifecycleOwner = this@DetailsActivity
            vm = viewModel.apply { fetchChampionInfo(championItem.name) }
        }

    }

    companion object {

        private const val EXTRA_CHAMPION = "EXTRA_CHAMPION"

        fun startActivity(transformationLayout: TransformationLayout, champion: Champion) {
            val context = transformationLayout.context
            if (context is Activity) {
                val intent = Intent(context, DetailsActivity::class.java)
                intent.putExtra(EXTRA_CHAMPION, champion)
                TransformationCompat.startActivity(transformationLayout, intent)
            }
        }
    }
}