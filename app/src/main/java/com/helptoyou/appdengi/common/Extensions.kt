package com.helptoyou.appdengi.common

import android.content.Context
import android.graphics.Rect
import android.view.View
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.google.android.material.dialog.MaterialAlertDialogBuilder

fun View.doOnApplyWindowInsets(block: (View, WindowInsetsCompat, Rect) -> WindowInsetsCompat) {

    val initialPadding =
            recordInitialPaddingForView(this)

    ViewCompat.setOnApplyWindowInsetsListener(this) { v, insets ->
        block(v, insets, initialPadding)
    }
}

private fun recordInitialPaddingForView(view: View) =
        Rect(view.paddingLeft, view.paddingTop, view.paddingRight, view.paddingBottom)

fun ImageView.loadImage(url: String) {
    Glide
            .with(this.context)
            .load(url)
            .centerCrop()
            .into(this)
}

fun Context.openErrorAlert() {
    MaterialAlertDialogBuilder(this)
            .setTitle("Ошибка")
            .setMessage("Произошла ошика на сервере. Повторите попытку в другое время")
            .setPositiveButton("Ok") { _, _ -> }
            .create()
            .show()
}