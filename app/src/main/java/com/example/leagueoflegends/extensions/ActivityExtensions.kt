package com.example.leagueoflegends.extensions

import android.app.Activity
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.google.android.material.transition.MaterialArcMotion
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialContainerTransformSharedElementCallback

const val TRANSITION_ACTIVITY = "TRANSITION_ACTIVITY_A"
const val TRANSITION_ACTIVITY_DURATION = 550L

fun AppCompatActivity.onTransformationEndContainerApplyParams() {
    window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
    ViewCompat.setTransitionName(findViewById<View>(android.R.id.content), TRANSITION_ACTIVITY)
    // Set up shared element transition and disable overlay so views don't show above system bars
    setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())

    val materialTransform = MaterialContainerTransform().apply {
        addTarget(android.R.id.content)
        duration = TRANSITION_ACTIVITY_DURATION
        pathMotion = MaterialArcMotion()
    }
    // Due to a bug in Material components 1.3.0-alpha02 we need to set a return Transformation manually
    val returnTransformation = MaterialContainerTransform().apply {
        addTarget(android.R.id.content)
        fadeMode = MaterialContainerTransform.FADE_MODE_CROSS
        isHoldAtEndEnabled = true
        duration = 450
    }
    window.sharedElementReturnTransition = returnTransformation
    window.sharedElementEnterTransition = materialTransform
}

/** sets an exit shared element callback to activity for implementing shared element transition. */
fun Activity.onTransformationStartContainer() {
    window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
    setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())
    window.sharedElementsUseOverlay = false
}

