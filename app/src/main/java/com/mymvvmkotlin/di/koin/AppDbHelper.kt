package com.mymvvmkotlin.di.koin

import com.mymvvmkotlin.data.local.db.AppDbHelper
import org.koin.dsl.module

val dbHelper = module {

    single { AppDbHelper(get()) }

}
