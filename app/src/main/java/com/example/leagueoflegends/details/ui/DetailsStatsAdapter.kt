package com.example.leagueoflegends.details.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.leagueoflegends.R
import com.example.leagueoflegends.databinding.ItemChampionStatsBinding
import com.example.leagueoflegends.model.Champion

class DetailsStatsAdapter : RecyclerView.Adapter<DetailsStatsAdapter.StatsViewHolder>() {

    private val items: MutableList<Champion.Stats> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatsViewHolder {
        val binding = ItemChampionStatsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StatsViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: StatsViewHolder, position: Int) {
        val item = items[position]
        holder.binding.apply {

        }
    }

    fun addStatsList(statsList: List<Champion.Stats>) {
        items.addAll(statsList)
        notifyDataSetChanged()
    }

    class StatsViewHolder(val binding: ItemChampionStatsBinding):
        RecyclerView.ViewHolder(binding.root)

    fun Champion.Stats.translate(context: Context) : Map<String, String> {
        val map = HashMap<String, String>()
        map.apply {
            put(hp.toString(), context.getString(R.string.hp))
            put(hpregen.toString(), context.getString(R.string.hpreg))
            put(hpregen.toString(), context.getString(R.string.hpreg))
        }
        return  map
    }
}

