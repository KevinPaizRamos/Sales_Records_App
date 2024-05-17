package com.example.hwrk3

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


//1. takes a SaleDatabase as parameter in the primary constructor
class SalesRepository constructor(salesDatabase: SalesDatabase) {
    val salesDao = salesDatabase.userDao()

    //2.. The SalesRepository class should contain code to
    //manipulate the Room database. All database queries should take place in a coroutine
suspend fun getAll():List<User> = salesDao!!.getAll()


 suspend fun insertSale(user:User)= salesDao!!.insert(user)



}

