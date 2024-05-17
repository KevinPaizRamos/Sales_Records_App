package com.example.hwrk3

import android.app.Application
import android.util.Log
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MyApp : Application(){
    companion object{
        lateinit var salesRepository: SalesRepository
    }

    override fun onCreate(){
        super.onCreate()
        //intialization taks here
        //set up global resources libraries
        //1. Run the data base creation code, inside a coroutine, use runblocking use Dispacher.IO
        runBlocking(Dispatchers.IO){
            val db = Room.databaseBuilder(
                applicationContext,
                SalesDatabase::class.java,"Sales"
            ).build()
            Log.d("MY_DEBUG","database created")
            salesRepository = SalesRepository(db)
        }
        //2.create the repository instance, pass the data bae reference in as a parameter to the constructor




    }
}