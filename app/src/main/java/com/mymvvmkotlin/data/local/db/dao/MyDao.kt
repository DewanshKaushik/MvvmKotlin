package com.mymvvmkotlin.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.mymvvmkotlin.data.model.db.MyModel

@Dao
interface MyDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertUser(userInfo: MyModel)

}