package com.webaddicted.techcleanarch.global.koin

import com.mymvvmkotlin.ui.main.MainViewModel
import com.mymvvmkotlin.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel(get(),get()) }
    viewModel { MainViewModel(get(),get()) }

}


