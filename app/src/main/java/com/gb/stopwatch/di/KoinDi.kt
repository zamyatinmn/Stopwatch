package com.gb.stopwatch.di

import com.gb.stopwatch.model.*
import com.gb.stopwatch.view.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


object KoinDi {
    val mainModule = module {
        viewModel { MainViewModel(stopwatchListOrchestrator = get()) }

        single<TimestampProvider> {
            object: TimestampProvider {
                override fun getMilliseconds(): Long {
                    return System.currentTimeMillis()
                }
            }
        }
        single { ElapsedTimeCalculator(timestampProvider = get()) }
        single {
            StopwatchStateCalculator(
                timestampProvider = get(),
                elapsedTimeCalculator = get()
            )
        }
        single { TimestampMillisecondsFormatter() }
        single {
            StopwatchStateHolder(
                stopwatchStateCalculator = get(),
                elapsedTimeCalculator = get(),
                timestampMillisecondsFormatter = get()
            )
        }
        single {
            StopwatchListOrchestrator(
                stopwatchStateHolder = get(),
                scope = CoroutineScope(Dispatchers.IO)
            )
        }
    }
}