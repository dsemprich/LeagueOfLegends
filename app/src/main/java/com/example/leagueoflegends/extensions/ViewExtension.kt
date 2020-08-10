package com.example.leagueoflegends.extensions

import android.graphics.drawable.GradientDrawable
import android.view.View

fun createGradient(colors: IntArray, orientation: GradientDrawable.Orientation): GradientDrawable {
    val gd = GradientDrawable(orientation, colors)
    gd.cornerRadius = 0f
    return gd
}

fun View.gone(shouldBeGone: Boolean) {
    visibility = if (shouldBeGone) {
        View.GONE
    } else {
        View.VISIBLE
    }
}