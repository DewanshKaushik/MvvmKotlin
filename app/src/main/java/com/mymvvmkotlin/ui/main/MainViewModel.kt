package com.mymvvmkotlin.ui.main

import com.mymvvmkotlin.data.AppDataManager
import com.mymvvmkotlin.ui.splash.base.BaseViewModel
import com.mymvvmkotlin.utils.rx.AppSchedulerProvider

class MainViewModel(
    private val appDataManager: AppDataManager,
    private val appSchedulerProvider: AppSchedulerProvider
) : BaseViewModel<MainContract?>(appDataManager, appSchedulerProvider) {


}