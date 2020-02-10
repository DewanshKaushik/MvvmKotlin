package com.webaddicted.techcleanarch.global.koin

import androidx.room.Room
import com.mymvvmkotlin.application.MyMvvmKotlinApplication
import com.mymvvmkotlin.data.local.db.AppDatabase
import com.mymvvmkotlin.utils.DbConstant
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dbModule = module(override = true) {

    single {
        Room.databaseBuilder(
            (androidApplication() as MyMvvmKotlinApplication),
            AppDatabase::class.java,
            DbConstant.DB_NAME
        ).allowMainThreadQueries().build()
    }

    single { (get() as AppDatabase).dmvDao() }
}