package com.aragones.paul.dawanda.extension

import android.animation.Animator
import android.view.View
import android.view.ViewPropertyAnimator

fun View.animationAlpha(duration: Long, alpha: Float): ViewPropertyAnimator {
    this.alpha = 1.0f - alpha
    val animate = this.animate()
    animate.duration = duration
    return animate.alpha(alpha)
}

fun concatenateAlphaAnimations(views: MutableList<View>, duration: Long, alpha: Float) {
    views.forEach {
        it.alpha = 1.0f - alpha
    }
    concatenateAlphaAnimationsRecursively(views, duration, alpha)
}

private fun concatenateAlphaAnimationsRecursively(views: MutableList<View>, duration: Long, alpha: Float) {
    if (views.isEmpty()) return
    val view = views.removeAt(0)
    view.animationAlpha(duration, alpha).setListener(object : Animator.AnimatorListener {
        override fun onAnimationRepeat(p0: Animator?) {
        }

        override fun onAnimationEnd(p0: Animator) {
            concatenateAlphaAnimationsRecursively(views, duration, alpha)
        }

        override fun onAnimationCancel(p0: Animator?) {
        }

        override fun onAnimationStart(p0: Animator?) {
        }
    })
}

