package com.mymvvmkotlin.application

import android.app.Application
import com.mymvvmkotlin.di.koin.*
import com.webaddicted.techcleanarch.global.koin.appModule
import com.webaddicted.techcleanarch.global.koin.dbModule
import com.webaddicted.techcleanarch.global.koin.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
//import org.koin.core.context.startKoin
//import org.koin.android.ext.android.startKoin
import org.koin.core.context.startKoin

import org.koin.core.module.Module

class MyMvvmKotlinApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyMvvmKotlinApplication)
            modules(getModule())
        }
    }


    private fun getModule(): Iterable<Module> {
        return listOf(
            appModule,
            viewModelModule,
            dbModule,
            dbHelper,
            appDataManager,
            appPreferencesHelper,
            appSchedulerProvider,
            repoModule
        )
    }

}