package com.mymvvmkotlin.data.local.db

class AppDbHelper(private val mAppDatabase: AppDatabase) : DbHelper{
    lateinit var database: AppDatabase

    init {
        database=mAppDatabase
    }

    fun getDatafromDb(){
        database.dmvDao()
    }

    override fun getData() {



    }
}