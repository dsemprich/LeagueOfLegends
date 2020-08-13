package com.example.leagueoflegends.details.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.leagueoflegends.R
import com.example.leagueoflegends.databinding.FragmentSpellBinding
import com.example.leagueoflegends.extensions.fromJson
import com.example.leagueoflegends.extensions.json
import com.example.leagueoflegends.model.ChampionDetail

private const val ARG_SPELL_OBJ = "object"

class SpellFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSpellBinding.inflate(inflater).apply {
            arguments?.takeIf { it.containsKey(ARG_SPELL_OBJ) }?.apply {
                val spells = getString(ARG_SPELL_OBJ).toString().fromJson<ChampionDetail.Spell>()
                textSpellTitle.text = spells.name
                textSpell.text = spells.description
            }
        }
        return binding.root
    }
}

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