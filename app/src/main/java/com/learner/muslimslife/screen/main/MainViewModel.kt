package com.learner.muslimslife.screen.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.learner.muslimslife.data.MainScreenNotify

class MainViewModel(application: Application) : AndroidViewModel(application) {


    val mainAtvNotfData = MutableLiveData<MainScreenNotify>()
    fun notifyMainActivity(msn: MainScreenNotify) {
        mainAtvNotfData.postValue(msn)
    }
}