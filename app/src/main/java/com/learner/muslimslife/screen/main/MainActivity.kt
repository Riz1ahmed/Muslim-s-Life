package com.learner.muslimslife.screen.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.learner.codereducer.utils.connectViewPager2WithBtmNav
import com.learner.muslimslife.data.MainScreenNotify
import com.learner.muslimslife.databinding.ActivityMainBinding
import com.learner.muslimslife.databinding.DrawerMainBinding
import com.learner.muslimslife.screen.SettingsActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentsConnectWithBottomNav()
        notificationObserver()
        setupDrawerFeatures()
    }

    private fun setupDrawerFeatures() {
        binding.navView.getHeaderView(0).apply {
            DrawerMainBinding.bind(this).let { headerBinding ->
                headerBinding.btnSettings.setOnClickListener {
                    startActivity(Intent(this@MainActivity, SettingsActivity::class.java))
                }
            }
        }
    }

    private fun fragmentsConnectWithBottomNav() {
        connectViewPager2WithBtmNav(
            supportFragmentManager, lifecycle,
            binding.vp2Fragments, binding.bnvFragments,
            listOf(RoutineFragment(), CalenderFragment(), RoutineFragment(), RoutineFragment())
        )
    }

    private fun notificationObserver() {
        viewModel.mainAtvNotfData.observe(this) {
            when (it) {
                MainScreenNotify.OPEN_NAV_DRAWER -> binding.root.openDrawer(GravityCompat.START)
            }
        }
    }
}