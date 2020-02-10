package com.mymvvmkotlin.ui.splash

import android.os.Bundle
import android.view.View
import com.mymvvmkotlin.R
import com.mymvvmkotlin.ui.splash.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : BaseActivity<SplashViewModel?>(), SplashContract {


    private val mViewModel: SplashViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.doLogin()
    }

    override fun onFragmentDetached(tag: String?) {
    }

    override fun getViewModel(): SplashViewModel? {
        return mViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    public fun showToastFromButton(view: View){
        showToast("Buttonclicked")
        mViewModel.doLogin()

    }

}