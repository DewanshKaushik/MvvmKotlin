package com.mymvvmkotlin.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mymvvmkotlin.data.local.db.dao.MyDao
import com.mymvvmkotlin.data.model.db.MyModel

@Database(entities = [MyModel::class], version = 1)

abstract class AppDatabase : RoomDatabase() {
    abstract fun dmvDao(): MyDao?

}