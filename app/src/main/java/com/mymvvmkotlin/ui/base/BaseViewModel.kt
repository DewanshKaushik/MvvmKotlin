package com.mymvvmkotlin.ui.splash.base

import androidx.lifecycle.ViewModel
import com.mymvvmkotlin.data.AppDataManager
import com.mymvvmkotlin.data.DataManager
import com.mymvvmkotlin.utils.rx.AppSchedulerProvider
import com.mymvvmkotlin.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

abstract class BaseViewModel<N>(
    val dataManager: DataManager,
    val schedulerProvider: SchedulerProvider
) : ViewModel() {

    val compositeDisposable: CompositeDisposable
    private var mNavigator: WeakReference<N>? = null


    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    val navigator: N?
        get() = mNavigator!!.get()

    fun setNavigator(navigator: N) {
        mNavigator = WeakReference(navigator)
    }

    init {
        compositeDisposable = CompositeDisposable()
    }
}