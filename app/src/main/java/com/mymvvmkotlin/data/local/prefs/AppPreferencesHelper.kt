package com.mymvvmkotlin.data.local.prefs

import android.content.Context
import android.content.SharedPreferences

class AppPreferencesHelper(
    context: Context,
    prefFileName: String?
) : PreferencesHelper {
    private val mPrefs: SharedPreferences

    companion object {
        private const val PREF_KEY = "KEY"
    }

    init {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)
    }

    override fun getname(){

    }
}