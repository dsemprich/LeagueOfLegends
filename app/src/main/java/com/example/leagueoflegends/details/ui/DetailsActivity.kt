package com.example.leagueoflegends.details.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import com.bumptech.glide.Glide
import com.example.leagueoflegends.R
import com.example.leagueoflegends.binding.bindingView
import com.example.leagueoflegends.databinding.ActivityDetailsBinding
import com.example.leagueoflegends.extensions.onTransformationEndContainerApplyParams
import com.example.leagueoflegends.model.Champion
import com.google.android.material.tabs.TabLayoutMediator
import com.skydoves.transformationlayout.TransformationCompat
import com.skydoves.transformationlayout.TransformationLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.tab_spells.view.*

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    private val binding: ActivityDetailsBinding by bindingView(R.layout.activity_details)
    private val viewModel: DetailViewModel by viewModels()

    private lateinit var spellAdapter: SpellAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        onTransformationEndContainerApplyParams()
        super.onCreate(savedInstanceState)
        val championItem: Champion = requireNotNull(intent.getParcelableExtra(EXTRA_CHAMPION))

        binding.apply {
            champion = championItem
            lifecycleOwner = this@DetailsActivity
            vm = viewModel.apply { fetchChampionInfo(championItem.name) }
            spellAdapter = SpellAdapter(this@DetailsActivity)
            pager.adapter = spellAdapter


        }
        viewModel.championInfoLiveData.observe(this) {
            spellAdapter.add(it?.spells)
            binding.tabLayout.apply {
                this.isTabIndicatorFullWidth = false
                TabLayoutMediator(this, binding.pager) { tab, position ->
                    tab.setCustomView(R.layout.tab_spells)
                    Glide.with(this@DetailsActivity)
                        .load(it?.spells?.get(position)?.spellImage())
                        .centerCrop()
                        .into(tab.view.icon)
                }.attach()
            }
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