package com.learner.muslimslife.screen.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.learner.muslimslife.R
import com.learner.muslimslife.databinding.FragTodaysRoutineBinding

class RoutineFragment : Fragment(R.layout.frag_todays_routine) {
    lateinit var binding: FragTodaysRoutineBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragTodaysRoutineBinding.bind(view)
    }
}