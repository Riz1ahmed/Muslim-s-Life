package com.learner.codereducer.views

import android.content.Context
import android.util.AttributeSet
import android.widget.SeekBar
import androidx.appcompat.widget.AppCompatSeekBar
import com.learner.codereducer.R

class NegativeSeekbar(context: Context, attributeSet: AttributeSet) :
    AppCompatSeekBar(context, attributeSet) {

    private var minimumValue = 0
    private var maximumValue = 0
    private var listener: OnSeekBarChangeListener? = null


    init {
        context.theme.obtainStyledAttributes(attributeSet, R.styleable.NegativeSeekBar, 0, 0)
            .apply {
                minimumValue = getInteger(R.styleable.NegativeSeekBar_minValue, 0)
                maximumValue = getInteger(R.styleable.NegativeSeekBar_maxValue, 0)

                min = minimumValue
                max = maximumValue

            }
    }


    override fun setMin(min: Int) {
        minimumValue = min
        super.setMax(maximumValue - minimumValue)
    }

    override fun setMax(max: Int) {
        maximumValue = max
        super.setMax(maximumValue - minimumValue)
    }

    override fun setOnSeekBarChangeListener(listener: OnSeekBarChangeListener) {
        this.listener = listener
    }

    private fun setUpInternalListener() {
        super.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (listener != null) {
                    listener!!.onProgressChanged(seekBar, minimumValue + i, b)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                if (listener != null) listener!!.onStartTrackingTouch(seekBar)
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                if (listener != null) listener!!.onStopTrackingTouch(seekBar)
            }
        })
    }
}