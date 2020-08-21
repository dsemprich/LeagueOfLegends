package com.example.leagueoflegends.details.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.leagueoflegends.extensions.json
import com.example.leagueoflegends.model.ChampionDetail

class SpellAdapter(
    fragmentActivity: FragmentActivity,
    private val spells: MutableList<ChampionDetail.Spell> = mutableListOf()
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = spells.size

    override fun createFragment(position: Int): Fragment {
        val fragment = SpellFragment()
        fragment.arguments = Bundle().apply {
            putString(ARG_SPELL_OBJ, spells[position].json())
        }
        return fragment
    }

    fun add(spells: List<ChampionDetail.Spell>?) {
        spells?.let {
            this.spells.addAll(it)
        }
        notifyDataSetChanged()
    }
}