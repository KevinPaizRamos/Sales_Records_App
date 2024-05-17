package com.example.hwrk3

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class],version= 1)
abstract class SalesDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao?
}