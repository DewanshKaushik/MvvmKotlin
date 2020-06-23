package com.mymvvmkotlin.ui.splash

import android.util.Log
import com.mymvvmkotlin.data.AppDataManager
import com.mymvvmkotlin.data.DataManager
import com.mymvvmkotlin.ui.splash.base.BaseViewModel
import com.mymvvmkotlin.utils.rx.AppSchedulerProvider
import com.mymvvmkotlin.utils.rx.SchedulerProvider

class SplashViewModel(
    private val appDataManager: DataManager,
    private val appSchedulerProvider: SchedulerProvider
) : BaseViewModel<SplashContract?>(appDataManager, appSchedulerProvider) {


    fun doLogin() {
        //d Log.e("hello","hello")
        appDataManager.getData()
        appDataManager.getname()
        navigator?.openMainActivity()
    }

}
