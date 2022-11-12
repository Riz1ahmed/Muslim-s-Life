package com.learner.codereducer.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.learner.codereducer.R
import com.learner.codereducer.databinding.MyButtonBinding

class MyButton(context: Context, attrs: AttributeSet? = null) : FrameLayout(context, attrs) {
    lateinit var binding: MyButtonBinding

    init {
                   //LayoutInflater.from(context).inflate(R.layout.my_button, this)

        val view = LayoutInflater.from(context).inflate(R.layout.my_button, this)
        //binding = MyButtonBinding.bind(view)
        removeAllViews()
        addView(view.rootView)

        //binding = MyButtonBinding.inflate(LayoutInflater.from(context))
        //removeAllViews()
        //addView(binding.root.rootView)
    }
}