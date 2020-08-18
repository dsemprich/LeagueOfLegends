package com.example.leagueoflegends.details.ui

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import coil.api.load
import com.example.leagueoflegends.R
import com.example.leagueoflegends.binding.bindingView
import com.example.leagueoflegends.databinding.ActivityDetailsBinding
import com.example.leagueoflegends.extensions.TRANSITION_ACTIVITY
import com.example.leagueoflegends.extensions.onTransformationEndContainerApplyParams
import com.example.leagueoflegends.model.Champion
import com.google.android.material.tabs.TabLayoutMediator
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
            vm = viewModel.apply { fetchChampionInfo(championItem.id) }
            spellAdapter = SpellAdapter(this@DetailsActivity)
            pager.adapter = spellAdapter


        }
        viewModel.championInfoLiveData.observe(this) {
            spellAdapter.add(it?.spells)
            binding.tabLayout.apply {
                this.isTabIndicatorFullWidth = false
                TabLayoutMediator(this, binding.pager) { tab, position ->
                    tab.setCustomView(R.layout.tab_spells)
                    tab.view.icon.load(it?.spells?.get(position)?.spellImage())
                }.attach()
            }
        }
    }

    companion object {

        private const val EXTRA_CHAMPION = "EXTRA_CHAMPION"

        fun startActivity(startView: View, champion: Champion) {
            val context = startView.context
            if (context is Activity) {
                val intent = Intent(context, DetailsActivity::class.java)
                intent.putExtra(EXTRA_CHAMPION, champion)
                val options = ActivityOptions.makeSceneTransitionAnimation(context, startView, TRANSITION_ACTIVITY )
                context.startActivity(intent, options.toBundle())
            }
        }
    }
}