package com.example.leagueoflegends.binding

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable.*
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.graphics.drawable.toBitmap
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.palette.graphics.Palette
import coil.api.load
import coil.bitmappool.BitmapPool
import coil.size.Size
import coil.transform.RoundedCornersTransformation
import coil.transform.Transformation
import com.example.leagueoflegends.extensions.createGradient
import com.example.leagueoflegends.extensions.gone
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
    view.load(url) {
        target {
            val input =it.toBitmap().copy(Bitmap.Config.ARGB_8888, false)
            val rgb = Palette.Builder(input).generate().mutedSwatch?.rgb
            if (rgb != null) {
                paletteCard.setCardBackgroundColor(rgb)
            }
            view.setImageDrawable(it)
        }
        crossfade(true)
    }
}

@BindingAdapter("paletteImage", "paletteView")
fun bindLoadImagePaletteView(view: AppCompatImageView, url: String, paletteView: View) {
    val context = view.context
    view.load(url) {

        target {
            val input =it.toBitmap().copy(Bitmap.Config.ARGB_8888, false)
            val palette = Palette.Builder(input).generate()
            val light = palette.mutedSwatch?.rgb
            val domain = palette.dominantSwatch?.rgb
            if (domain != null) {
                if (light != null) {
                    val gradient = createGradient(intArrayOf(light, domain), Orientation.TOP_BOTTOM)
                    paletteView.background = gradient
                    if (context is AppCompatActivity) {
                        context.window.apply {
                            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                            statusBarColor = light
                        }
                    }
                    view.setImageDrawable(it)
                } else {
                    paletteView.setBackgroundColor(domain)
                }
            }
        }
        crossfade(true)
    }
}

private fun toPaletteView(
    it: Drawable,
    paletteView: View,
    context: Context?,
    view: AppCompatImageView
) {
    val input = (it as BitmapDrawable).bitmap
    val palette = Palette.Builder(input).generate()
    val light = palette.mutedSwatch?.rgb
    val domain = palette.dominantSwatch?.rgb
    if (domain != null) {
        if (light != null) {
            val gradient = createGradient(intArrayOf(light, domain), Orientation.TOP_BOTTOM)
            paletteView.background = gradient
            if (context is AppCompatActivity) {
                context.window.apply {
                    addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                    statusBarColor = light
                }
            }
            view.setImageDrawable(it)
        } else {
            paletteView.setBackgroundColor(domain)
        }
    }
}