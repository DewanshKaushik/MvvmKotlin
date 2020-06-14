package com.mymvvmkotlin.ui.splash.main

import android.os.Bundle
import com.mymvvmkotlin.R
import com.mymvvmkotlin.ui.main.MainViewModel
import com.mymvvmkotlin.ui.splash.SplashContract
import com.mymvvmkotlin.ui.splash.base.BaseActivity

class MainActivity : BaseActivity<MainViewModel?>(), SplashContract {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onFragmentDetached(tag: String?) {
        TODO("Not yet implemented")
    }

    override fun getViewModel(): MainViewModel? {
        TODO("Not yet implemented")
    }

    override fun getLayoutId(): Int {
        TODO("Not yet implemented")
    }


}
