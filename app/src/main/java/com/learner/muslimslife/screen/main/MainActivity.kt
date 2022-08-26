package com.learner.muslimslife.screen.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learner.muslimslife.databinding.ActivityMainBinding
import com.learner.muslimslife.utils.connectViewPager2WithBtmNav

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        connectViewPager2WithBtmNav(
            supportFragmentManager, lifecycle,
            binding.vp2Fragments, binding.bnvFragments,
            listOf(RoutineFragment(), CalenderFragment(), RoutineFragment(), RoutineFragment())
        )
    }
}