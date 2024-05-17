package com.example.hwrk3

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hwrk3.MyApp.Companion.salesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddSalesVM constructor(var salesRepository: SalesRepository): ViewModel() {

    fun addSales(name:String,amount:Double){
        viewModelScope.launch(Dispatchers.IO){
            try {
                salesRepository.insertSale(User(name, amount))
                Log.d("AddSaleVM", "Sale added successfully: $name, $amount")
            } catch (e: Exception) {
                Log.e("AddSaleVM", "Error adding sale", e)
            }
        }
    }
}