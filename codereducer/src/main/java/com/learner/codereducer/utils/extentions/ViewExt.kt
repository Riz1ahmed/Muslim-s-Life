package com.learner.codereducer.utils.extentions

import android.animation.LayoutTransition
import android.content.Context
import android.graphics.PorterDuff
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.ViewTreeObserver
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.annotation.AnimRes
import androidx.annotation.ColorRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun View.setViewReadyListener(block: () -> Unit) {
    this.viewTreeObserver.addOnGlobalLayoutListener(object :
        ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            //Layout binding ready
            block.invoke()
            this@setViewReadyListener.viewTreeObserver.removeOnGlobalLayoutListener(this)
        }
    })
}

/**Every [delay] millisecond later check whether the view is ready. if ready call [block]*/
fun View.setViewReadyListener(block: (View) -> Unit, delay: Long = 80) {
    waitTillFalse({
        return@waitTillFalse width > 0
    }, {}, {
        block(this)
    }, delay)
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun View.hideIf() {
    if (isVisible) visibility = View.GONE
}


fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.applyClickEffect() {
    alpha = .50f
    Handler(Looper.getMainLooper()).postDelayed({ alpha = 1f }, 200)
}

fun TextView.applyClickColorEffect(@ColorRes effectColor: Int, @ColorRes orgColor: Int) {
    //val tColor = orgColor ?: this.currentTextColor
    ContextCompat.getColor(this.context, effectColor).let { color ->
        setTextColor(color)
        for (drawable in this.compoundDrawables) drawable?.changeColor(color)
    }
    Handler(Looper.getMainLooper()).postDelayed({
        ContextCompat.getColor(this.context, orgColor).let { color ->
            setTextColor(color)
            for (drawable in this.compoundDrawables) drawable?.changeColor(color)
        }
    }, 100)
}

fun ImageView.applyClickColorEffect(@ColorRes effectColor: Int, @ColorRes orgColor: Int) {
    setColorFilter(ContextCompat.getColor(this.context, effectColor), PorterDuff.Mode.SRC_IN)
    Handler(Looper.getMainLooper()).postDelayed({
        setColorFilter(ContextCompat.getColor(this.context, orgColor), PorterDuff.Mode.SRC_IN)
    }, 100)
}

fun ImageView.setColor(@ColorRes color: Int) {
    setColorFilter(ContextCompat.getColor(this.context, color), PorterDuff.Mode.SRC_IN)
}

fun TextView.changeColor(@ColorRes resColorId: Int) {
    ContextCompat.getColor(this.context, resColorId).let { color ->
        setTextColor(color)
        for (drawable in this.compoundDrawables) drawable?.changeColor(color)
    }
}

/**
 * Repeatedly call this method when user scrolled to end of this recyclerView.
 * @see layoutmanager must be GridLayoutManager of this recyclerview
 */
fun RecyclerView.onScrolledToEndListener(scrolled2End: () -> Unit) {
    val gridLayoutManager = layoutManager as GridLayoutManager
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            if (gridLayoutManager.findLastVisibleItemPosition() == gridLayoutManager.itemCount - 1)
                scrolled2End.invoke()
            super.onScrolled(recyclerView, dx, dy)
        }
    })
}

fun View.applyAnimation(f: Fragment, @AnimRes animResource: Int) =
    f.context?.let { applyAnimation(it, animResource) }

fun View.applyAnimation(context: Context, @AnimRes animResource: Int) =
    this.startAnimation(AnimationUtils.loadAnimation(context, animResource))

/**
 * @param continueCall Till hold the view continuously call this method with [delay].
 * @param holdUp when holdUp (Last time) will call this method
 * @param delay in Millisecond. how many time wait to repeat call [continueCall] method.
 * Default value is 50millisecond.
 */
fun View.setHoldingListener(continueCall: () -> Unit, holdUp: () -> Unit, delay: Long = 50) {
    setOnLongClickListener {
        waitTillFalse(
            conditionCode = { return@waitTillFalse !isPressed },
            falseCode = { continueCall.invoke() },
            trueCode = { holdUp.invoke() },
            delay = delay
        )
        return@setOnLongClickListener true
    }
}

fun SeekBar.setSeekbarChangeListener(block: (Int) -> Unit) {
    setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            block(progress)
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {}

        override fun onStopTrackingTouch(seekBar: SeekBar?) {}
    })
}

/**
 * 1st add " android:animateLayoutChanges="true" in this view at xml"
 * Otherwise will get NullPointerException*/
fun ConstraintLayout.enableAnimation() {
    layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
}