package com.mymvvmkotlin.ui.splash

import com.mymvvmkotlin.data.AppDataManager
import com.mymvvmkotlin.ui.splash.base.BaseViewModel
import com.mymvvmkotlin.utils.rx.AppSchedulerProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.subscribe
import kotlinx.coroutines.runBlocking

class SplashViewModel(
    private val appDataManager: AppDataManager,
    private val appSchedulerProvider: AppSchedulerProvider
) : BaseViewModel<SplashContract?>(appDataManager, appSchedulerProvider) {


    fun doLogin() {
        //d Log.e("hello","hello")
        appDataManager.getData()
        appDataManager.getname()
        navigator?.openMainActivity()
    }

}

/*fun main() {
    GlobalScope.launch {
        delay(1000)
        print("World!")
    }
    print("hello ")
    Thread.sleep(2000)
}*/

@InternalCoroutinesApi
fun main() {
    var i = 0;
    var j = 1000000;
    for (i in 1..1000000) {
        println(i)
    }
    runBlocking {
        flowOperator();
    }
/*    runBlocking {
        repeat(1000000) {
            launch {
                i++
                print("$i . ")
            }
        }
    }*/
}

suspend fun flowOperator() {
    (1..10).asFlow()
        .flowOn(Dispatchers.IO)
        .collect {
            println(it)
        }
}




