package com.example.leagueoflegends.main.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.leagueoflegends.databinding.ItemChampionBinding
import com.example.leagueoflegends.details.ui.DetailsActivity
import com.example.leagueoflegends.extensions.TRANSITION_ACTIVITY_DURATION
import com.example.leagueoflegends.model.Champion

class ChampionsAdapter : RecyclerView.Adapter<ChampionsAdapter.ChampionViewHolder>() {

    private val items: MutableList<Champion> = mutableListOf()
    private var onClickedTime = System.currentTimeMillis()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChampionViewHolder {
        val binding = ItemChampionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChampionViewHolder(binding)
    }

    fun addChampionList(championList: List<Champion>) {
        items.addAll(championList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ChampionViewHolder, position: Int) {
        val item = items[position]
        holder.binding.apply {
            champion = item
            executePendingBindings()
            root.setOnClickListener {
                val currentTime = System.currentTimeMillis()
                if (currentTime - onClickedTime > TRANSITION_ACTIVITY_DURATION) {
                    onClickedTime = currentTime
                    DetailsActivity.startActivity(transformationLayout, item)
                }
            }
        }
    }

    class ChampionViewHolder(val binding: ItemChampionBinding) :
        RecyclerView.ViewHolder(binding.root)
}