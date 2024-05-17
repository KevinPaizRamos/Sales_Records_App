package com.example.hwrk3

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hwrk3.MyApp.Companion.salesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SalesListVM constructor(salesRepository: SalesRepository) : ViewModel() {
    private var _salesList = mutableStateOf(listOf<User>())
    val salesList: State<List<User>> = _salesList

init {
    getAllSalesRecords()
}

    fun getAllSalesRecords() {
        viewModelScope.launch(Dispatchers.IO) {
            try{
                val deferredResult = async {

                    salesRepository.getAll()
                }
                val queryResult = deferredResult.await()

                withContext(Dispatchers.Main) {
                    _salesList.value = queryResult
                }
                Log.d("SalesListVM", "Fetched sales: ${queryResult.joinToString()}")

            }catch(e: Exception){
                Log.e("SalesListVM", "Error fetching sales", e)

            }

        }
    }
}

