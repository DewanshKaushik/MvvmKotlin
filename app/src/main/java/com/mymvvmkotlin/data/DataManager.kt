package com.mymvvmkotlin.data

import com.mymvvmkotlin.data.local.db.DbHelper
import com.mymvvmkotlin.data.local.prefs.PreferencesHelper

interface DataManager : DbHelper, PreferencesHelper