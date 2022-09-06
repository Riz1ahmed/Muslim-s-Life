package com.learner.muslimslife.screen.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.learner.muslimslife.R
import com.learner.muslimslife.data.MainScreenNotify
import com.learner.muslimslife.databinding.FragTodaysRoutineBinding

class RoutineFragment : Fragment(R.layout.frag_todays_routine) {
    lateinit var binding: FragTodaysRoutineBinding
    private val viewModel by activityViewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragTodaysRoutineBinding.bind(view)

        binding.btnDrawer.setOnClickListener {
            viewModel.notifyMainActivity(MainScreenNotify.OPEN_NAV_DRAWER)
        }
    }
}