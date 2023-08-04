package com.example.sportapplication.ui.util

import android.animation.ObjectAnimator
import android.view.View
import androidx.core.animation.doOnEnd

fun View.animationAppearanceFromZeroAlpha(duration: Long, endAction: () -> Unit) {
    this.alpha = 0f

    val animator = ObjectAnimator.ofFloat(
        this, View.ALPHA, 1f
    ).apply {
        this.duration = duration
        doOnEnd {
            endAction.invoke()
        }
    }
    animator.start()
}