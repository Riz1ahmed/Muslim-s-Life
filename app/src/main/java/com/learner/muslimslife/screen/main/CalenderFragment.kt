package com.learner.muslimslife.screen.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.learner.muslimslife.R
import com.learner.muslimslife.databinding.FragCalenderBinding
import com.learner.muslimslife.databinding.ItemCalenderBinding
import com.learner.codereducer.utils.MyGlobalAdapter

class CalenderFragment : Fragment(R.layout.frag_calender) {
    lateinit var binding: FragCalenderBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragCalenderBinding.bind(view)

        binding.rvCalender.adapter =
            object : MyGlobalAdapter<ItemCalenderBinding>(ItemCalenderBinding::inflate, 200) {
                override fun bind(binder: ItemCalenderBinding, position: Int) {}
            }
    }
}