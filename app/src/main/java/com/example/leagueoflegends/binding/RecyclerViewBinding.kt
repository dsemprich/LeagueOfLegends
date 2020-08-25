package com.example.leagueoflegends.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.leagueoflegends.base.RecyclerViewPaginator
import com.example.leagueoflegends.main.ui.ChampionsAdapter
import com.example.leagueoflegends.main.ui.MainViewModel
import com.example.leagueoflegends.model.Champion

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("paginationChampionList")
fun paginationChampionList(view: RecyclerView, viewModel: MainViewModel) {
    RecyclerViewPaginator(
        recyclerView = view,
        isLoading = { viewModel.isLoading.get() },
        loadMore = { viewModel.fetchChampionsList() },
        onLast = { false }
    ).run {
        threshold = 8
    }
}

@BindingAdapter("adapterChampionList")
fun bindAdapterChampionList(view: RecyclerView, championList: List<Champion>?) {
    championList?.let {
        (view.adapter as? ChampionsAdapter)?.addChampionList(it)
    }
}