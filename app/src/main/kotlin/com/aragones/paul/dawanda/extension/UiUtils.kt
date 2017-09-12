package com.aragones.paul.dawanda.extension

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.v4.content.ContextCompat
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.TextView

fun View.scale(ratio: Float) {
    scaleWidth(ratio)
    scaleHeight(ratio)
}

fun View.scaleWidth(ratio: Float) {
    val imageViewLayoutParams = layoutParams
    imageViewLayoutParams.width = (imageViewLayoutParams.width * ratio).toInt()
    layoutParams = imageViewLayoutParams
}

fun View.scaleHeight(ratio: Float) {
    val imageViewLayoutParams = layoutParams
    imageViewLayoutParams.height = (imageViewLayoutParams.height * ratio).toInt()
    layoutParams = imageViewLayoutParams
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun Drawable.setBounds(size: Int) = setBounds(width = size, height = size)
fun Drawable.setBounds(width: Int = bounds.right - bounds.left, height: Int = bounds.bottom - bounds.bottom) =
        setBounds(bounds.left, bounds.top, bounds.left + width, bounds.top + height)

fun <T : ViewGroup.MarginLayoutParams> T.setMargins(start: Int? = null, top: Int? = null, end: Int? = null, bottom: Int? = null): T {
    start?.let {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) this.leftMargin = it
        else this.marginStart = it
    }
    top?.let { this.topMargin = it }
    end?.let {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) this.rightMargin = it
        else this.marginEnd = it
    }
    bottom?.let { this.bottomMargin = it }
    return this
}

fun <T : ViewGroup.LayoutParams> T.setSize(width: Int, height: Int): T {
    this.width = width
    this.height = height
    return this
}

fun <T : GridLayout.LayoutParams> T.chainSetGravity(gravity: Int): T {
    this.setGravity(gravity)
    return this
}

fun Context.compatDrawable(id: Int): Drawable {
    val drawable: Drawable
    if (Build.VERSION.SDK_INT >= 21) {
        drawable = this.resources.getDrawable(id, this.theme)
    } else {
        @Suppress("DEPRECATION")
        drawable = this.resources.getDrawable(id)
    }
    return drawable
}

fun Resources.compatDrawable(id: Int, context: Context): Drawable {
    val drawable: Drawable
    if (Build.VERSION.SDK_INT >= 21) {
        drawable = this.getDrawable(id, context.theme)
    } else {
        @Suppress("DEPRECATION")
        drawable = this.getDrawable(id)
    }
    return drawable
}
