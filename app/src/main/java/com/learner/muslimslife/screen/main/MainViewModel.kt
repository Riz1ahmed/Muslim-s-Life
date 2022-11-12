package com.learner.muslimslife.screen.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.learner.codereducer.utils.TimeUtils
import com.learner.muslimslife.data.DayData
import com.learner.muslimslife.data.MainScreenNotify
import com.learner.muslimslife.data.SalahLifeTimeData
import com.learner.muslimslife.data.TimeDetail

class MainViewModel(application: Application) : AndroidViewModel(application) {

    /**Structure: Month,Day,Fajr,Sunrise,Dhuhr,Asr,Maghrib,Isha
     * Please split with comma ,
     * */
    val salahLifeTimeDatas = SalahLifeTimeData.times.split('|')

    val mainAtvNotfData = MutableLiveData<MainScreenNotify>()
    fun notifyMainActivity(msn: MainScreenNotify) {
        mainAtvNotfData.postValue(msn)
    }

    fun getDatas(position: Int): DayData {
        return salahLifeTimeDatas[position].toDayData()

        /*val data = salahLifeTimeDatas[position].split(',')
        return DayData(
            month = data[0].dropLastWhile { it == ' ' },
            day = data[1].toInt(),
            fajr = TimeDetail(data[2]),
            sunrise = TimeDetail(data[3]),
            juhr = TimeDetail(data[4]),
            asr = TimeDetail(data[5]),
            magrib = TimeDetail(data[6]),
            isha = TimeDetail(data[7]),
        )*/
    }

    fun getTodaysData(): DayData {
        val currMonthAndDay = TimeUtils.getCurrentDAndTFormat("MMMM dd").split(' ')
        val data = salahLifeTimeDatas.first { json ->
            json.split(',').let { dayDataStr ->
                dayDataStr[0].equals(currMonthAndDay[0], true)
                        && dayDataStr[1].toInt() == currMonthAndDay[1].toInt()
            }
        }
        return data.toDayData()
    }

    private fun String.toDayData(): DayData {
        val data = split(',')
        return DayData(
            month = data[0].dropLastWhile { it == ' ' },
            day = data[1].toInt(),
            fajr = TimeDetail(data[2]),
            sunrise = TimeDetail(data[3]),
            juhr = TimeDetail(data[4]),
            asr = TimeDetail(data[5]),
            magrib = TimeDetail(data[6]),
            isha = TimeDetail(data[7]),
        )
    }
}