package com.example.leagueoflegends.extensions

import android.app.Activity
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.transition.MaterialContainerTransformSharedElementCallback
import com.skydoves.transformationlayout.onTransformationEndContainer

fun AppCompatActivity.onTransformationEndContainerApplyParams() {
    onTransformationEndContainer(intent.getParcelableExtra("com.skydoves.transformationlayout"))
}


/** sets an exit shared element callback to activity for implementing shared element transition. */
fun Activity.onTransformationStartContainer() {
    window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
    setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())
    window.sharedElementsUseOverlay = false
}