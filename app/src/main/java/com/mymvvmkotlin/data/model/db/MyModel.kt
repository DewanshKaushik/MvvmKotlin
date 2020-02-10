package com.mymvvmkotlin.data.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class MyModel {
    @JvmField
    @PrimaryKey
    var id: String = ""
}