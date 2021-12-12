package com.gb.stopwatch.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.gb.stopwatch.model.StopwatchListOrchestrator
import kotlinx.coroutines.flow.collect


class MainViewModel(
    private val stopwatchListOrchestrator: StopwatchListOrchestrator,
): ViewModel() {

    private val _liveData = liveData { stopwatchListOrchestrator.ticker.collect(this::emit) }

    val liveData: LiveData<String>
        get() = _liveData

    fun start() = stopwatchListOrchestrator.start()

    fun pause() = stopwatchListOrchestrator.pause()

    fun stop() = stopwatchListOrchestrator.stop()
}