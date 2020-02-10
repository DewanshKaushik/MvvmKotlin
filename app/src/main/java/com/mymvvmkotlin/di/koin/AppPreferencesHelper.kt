package com.mymvvmkotlin.di.koin

import com.mymvvmkotlin.data.local.prefs.AppPreferencesHelper
import org.koin.dsl.module

val appPreferencesHelper = module {
    single { AppPreferencesHelper(get(),"pref_filename") }
}