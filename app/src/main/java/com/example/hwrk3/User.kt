package com.example.hwrk3

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val name:String,
    @ColumnInfo(name = "amount")val amount:Double?
)
