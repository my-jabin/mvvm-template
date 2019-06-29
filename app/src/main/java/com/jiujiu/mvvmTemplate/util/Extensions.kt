package com.jiujiu.mvvmTemplate.util

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import androidx.annotation.ColorRes
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat

fun Canvas.drawTextCenter(@NonNull text: String, x: Float, y: Float, @NonNull paint: Paint) {
    Rect().let {
        paint.getTextBounds(text, 0, text.length, it)
        drawText(text, x - it.centerX(), y - it.centerY(), paint)
    }
}

fun Context.color(@ColorRes id: Int): Int = ContextCompat.getColor(this, id)