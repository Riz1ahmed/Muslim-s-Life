package com.learner.muslimslife.data

@Suppress("SpellCheckingInspection")
data class DayData(
    val month: String,
    val day: Int,
    val fajr: TimeDetail,
    val sunrise: TimeDetail,
    val juhr: TimeDetail,
    val asr: TimeDetail,
    val magrib: TimeDetail,
    val isha: TimeDetail,
)
