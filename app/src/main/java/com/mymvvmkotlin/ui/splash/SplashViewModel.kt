package com.mymvvmkotlin.ui.splash

import android.util.Log
import com.mymvvmkotlin.data.AppDataManager
import com.mymvvmkotlin.ui.splash.base.BaseViewModel
import com.mymvvmkotlin.utils.rx.AppSchedulerProvider

class SplashViewModel(
    private val appDataManager: AppDataManager,
    private val appSchedulerProvider: AppSchedulerProvider
) : BaseViewModel<SplashContract?>(appDataManager, appSchedulerProvider) {


    fun doLogin() {
        Log.e("hello","hello")
        appDataManager.getData()
        appDataManager.getname()
    }

}
