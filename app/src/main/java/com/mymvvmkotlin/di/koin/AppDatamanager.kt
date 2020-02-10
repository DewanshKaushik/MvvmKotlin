package com.mymvvmkotlin.di.koin

import com.mymvvmkotlin.data.AppDataManager
import org.koin.dsl.module

val appDataManager = module {
    single { AppDataManager(get(),get(),get(),get(),get(),get()) }
}