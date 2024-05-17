package com.example.hwrk3

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Insert
    fun insert(userList: List<User>)

    @Query("DELETE FROM User")
    fun deleteAllUser()

    @Insert
    fun insert(user:User)

    @Delete
    fun delete(user:User)

}