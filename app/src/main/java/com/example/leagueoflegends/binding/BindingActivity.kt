package com.example.leagueoflegends.binding

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

fun <T : ViewDataBinding> AppCompatActivity.bindingView(
    @LayoutRes resId: Int
): Lazy<T> = lazy { DataBindingUtil.setContentView<T>(this, resId) }