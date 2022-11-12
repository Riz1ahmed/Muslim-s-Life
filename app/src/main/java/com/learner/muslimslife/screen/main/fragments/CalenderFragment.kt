package com.learner.muslimslife.screen.main.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.learner.codereducer.utils.MyGlobalAdapter
import com.learner.muslimslife.R
import com.learner.muslimslife.data.MainScreenNotify
import com.learner.muslimslife.databinding.FragCalenderBinding
import com.learner.muslimslife.databinding.ItemCalenderBinding
import com.learner.muslimslife.screen.main.MainViewModel

class CalenderFragment : Fragment(R.layout.frag_calender) {
    lateinit var binding: FragCalenderBinding
    private val viewModel by activityViewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragCalenderBinding.bind(view)

        binding.rvCalender.adapter =
            object : MyGlobalAdapter<ItemCalenderBinding>(
                ItemCalenderBinding::inflate, viewModel.salahLifeTimeDatas.size
            ) {
                override fun bind(binder: ItemCalenderBinding, position: Int) {
                    val dayData = viewModel.getDatas(position)

                    binder.txtDayNo.text = dayData.day.toString()
                    binder.txtMonthWithYr.text = "${dayData.month} 2022"

                    binder.txtFajrStartTime.text = "${dayData.fajr.hour}:${dayData.fajr.minutes}:"
                    binder.txtFajtEndTime.text = "${dayData.sunrise.hour}:${dayData.juhr.minutes-1}:"


                    binder.txtJuhrStartTime.text = "${dayData.juhr.hour}:${dayData.juhr.minutes}:"
                    binder.txtTxtJuhrEndTime.text = "${dayData.asr.hour}:${dayData.asr.minutes-1}:"

                    binder.txtAsrStartTime.text = "${dayData.asr.hour}:${dayData.asr.minutes}:"
                    binder.txtAsrEndTime.text = "${dayData.magrib.hour}:${dayData.magrib.minutes-4}:"

                    binder.txtMagribStartTime.text = "${dayData.magrib.hour}:${dayData.magrib.minutes}:"
                    binder.txtMagribEndTime.text = "${dayData.isha.hour}:${dayData.isha.minutes-1}:"

                    binder.txtIshaStartTime.text = "${dayData.isha.hour}:${dayData.isha.minutes}:"
                    binder.txtIshaEndTime.text = "${dayData.fajr.hour}:${dayData.fajr.minutes-4}:"
                }
            }

        binding.btnDrawer.setOnClickListener {
            viewModel.notifyMainActivity(MainScreenNotify.OPEN_NAV_DRAWER)
        }
    }
}