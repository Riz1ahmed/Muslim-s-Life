package com.learner.muslimslife.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learner.muslimslife.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    lateinit var binder: ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binder.root)
    }
}