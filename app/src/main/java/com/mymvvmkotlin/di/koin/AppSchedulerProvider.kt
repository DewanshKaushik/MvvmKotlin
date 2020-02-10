package com.mymvvmkotlin.di.koin

import com.mymvvmkotlin.utils.rx.AppSchedulerProvider
import org.koin.dsl.module

val appSchedulerProvider = module {
    single { AppSchedulerProvider() }
}