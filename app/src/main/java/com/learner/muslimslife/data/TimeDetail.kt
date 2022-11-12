package com.learner.muslimslife.data

data class TimeDetail(
    val hour: Int,
    val minutes: Int,
    val isPM: Boolean,
) {
    constructor(data: String) : this(
        hour = data.split(':')[0].toInt(),
        minutes = data.split(':')[1].toInt(),
        isPM = data.split(':')[2] == "PM"
    )
}
