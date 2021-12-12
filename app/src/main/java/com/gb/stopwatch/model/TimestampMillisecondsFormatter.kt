package com.gb.stopwatch.model

class TimestampMillisecondsFormatter {

    companion object {
        const val DEFAULT_TIME = "00:00:000"
        private const val MILLIS_IN_A_SEC = 1000
        private const val SECONDS_IN_A_MINUTE = 60
        private const val MINUTES_IN_AN_HOUR = 60
    }

    fun format(timestamp: Long): String {
        val millisecondsFormatted = (timestamp % MILLIS_IN_A_SEC).pad(3)
        val seconds = timestamp / MILLIS_IN_A_SEC
        val secondsFormatted = (seconds % SECONDS_IN_A_MINUTE).pad(2)
        val minutes = seconds / SECONDS_IN_A_MINUTE
        val minutesFormatted = (minutes % MINUTES_IN_AN_HOUR).pad(2)
        val hours = minutes / MINUTES_IN_AN_HOUR
        return if (hours > 0) {
            val hoursFormatted = (minutes / MINUTES_IN_AN_HOUR).pad(2)
            "$hoursFormatted:$minutesFormatted:$secondsFormatted"
        } else {
            "$minutesFormatted:$secondsFormatted:$millisecondsFormatted"
        }
    }

    private fun Long.pad(desiredLength: Int) = this.toString().padStart(desiredLength, '0')

}