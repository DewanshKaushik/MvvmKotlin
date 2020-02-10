package com.mymvvmkotlin.di.koin


import com.mymvvmkotlin.data.remote.NewsRepository
import org.koin.dsl.module


val repoModule = module {

    single { NewsRepository(get()) }

}