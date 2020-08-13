package com.example.leagueoflegends.binding

import android.app.Activity
import android.graphics.drawable.GradientDrawable.*
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import com.bumptech.glide.Glide
import com.example.leagueoflegends.extensions.createGradient
import com.example.leagueoflegends.extensions.gone
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette
import com.google.android.material.card.MaterialCardView

@BindingAdapter("toast")
fun bindToast(view: View, text: LiveData<String>) {
    text.value?.let {
        Toast.makeText(view.context, it, Toast.LENGTH_SHORT).show()
    }
}

@BindingAdapter("gone")
fun bindGone(view: View, shouldBeGone: Boolean) {
    view.gone(shouldBeGone)
}

@BindingAdapter("onBackPressed")
fun bindOnBackPressed(view: View, finish: Boolean) {
    val context = view.context
    if (finish && context is Activity) {
        view.setOnClickListener {
            context.onBackPressed()
        }
    }
}

@BindingAdapter("paletteImage", "paletteCard")
fun bindLoadImagePalette(view: AppCompatImageView, url: String, paletteCard: MaterialCardView) {
    Glide.with(view.context)
        .load(url)
        .listener(
            GlidePalette.with(url)
            .use(BitmapPalette.Profile.MUTED_LIGHT)
            .intoCallBack { palette ->
                val rgb = palette?.mutedSwatch?.rgb
                if (rgb != null) {
                    paletteCard.setCardBackgroundColor(rgb)
                }
            }
            .crossfade(true))
        .into(view)
}

@BindingAdapter("paletteImage", "paletteView")
fun bindLoadImagePaletteView(view: AppCompatImageView, url: String, paletteView: View) {
    val context = view.context
    Glide.with(context)
        .load(url)
        .listener(GlidePalette.with(url)
            .use(BitmapPalette.Profile.MUTED_LIGHT)
            .intoCallBack { palette ->
                val light = palette?.mutedSwatch?.rgb
                val domain = palette?.dominantSwatch?.rgb
                if (domain != null) {
                    if (light != null) {
//                        val gradient = createGradient(intArrayOf(domain, light), Orientation.TOP_BOTTOM)
                        val gradient = createGradient(intArrayOf(light, domain), Orientation.TOP_BOTTOM)
                        paletteView.background = gradient
                    } else {
                        paletteView.setBackgroundColor(domain)
                    }
                    if (context is AppCompatActivity) {
                        context.window.apply {
                            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                            statusBarColor = domain
                        }
                    }
                }
            }.crossfade(true))
        .into(view)
}