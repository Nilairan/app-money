package com.helptoyou.appdengi.common

import android.graphics.Rect
import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

fun View.doOnApplyWindowInsets(block: (View, WindowInsetsCompat, Rect) -> WindowInsetsCompat) {

    val initialPadding =
        recordInitialPaddingForView(this)

    ViewCompat.setOnApplyWindowInsetsListener(this) { v, insets ->
        block(v, insets, initialPadding)
    }
}

private fun recordInitialPaddingForView(view: View) =
    Rect(view.paddingLeft, view.paddingTop, view.paddingRight, view.paddingBottom)