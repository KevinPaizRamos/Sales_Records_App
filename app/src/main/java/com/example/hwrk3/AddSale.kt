package com.example.hwrk3

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue


import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun AddSaleScreen(navController:NavHostController){

    val addSaleViewModel = viewModel { AddSalesVM(MyApp.salesRepository)}
    var name by rememberSaveable { mutableStateOf("") }
    var amount by rememberSaveable { mutableStateOf("") }

    val navItemsList = listOf(
        MyNavItem(
            title = "Home",
            iconSelected = Icons.Filled.Home,
            iconUnselected = Icons.Outlined.Home,
            route = "SaleListScreen"
        ),
        MyNavItem(
            title = "Add",
            iconSelected = Icons.Filled.Add,
            iconUnselected = Icons.Outlined.Add,
            route = "AddSaleScreen"
        ),
    )
    var selectedItemIndex by rememberSaveable { mutableStateOf(1) }
    Scaffold(
        bottomBar = {
            NavigationBar {
                navItemsList.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = (selectedItemIndex == index),
                        onClick = {
                            selectedItemIndex = index
                            navController.navigate(item.route)
                        },
                        label = { Text(text = item.title) },
                        icon = {
                            Icon(
                                contentDescription = item.title,
                                imageVector = if (index == selectedItemIndex) item.iconSelected else item.iconUnselected
                            )
                        }
                    )
                }
            }
        }
    ) {padding->
        Column( modifier = Modifier.fillMaxSize()) {


            Surface(
                modifier = Modifier.padding(20.dp),
                shape = RoundedCornerShape(10.dp),
                shadowElevation = 30.dp

            ) {
                Column(modifier = Modifier.padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    DisplayHeading(heading = "Add Sale")
                    TextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Name") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    TextField(
                        value = amount,
                        onValueChange = { amount = it },
                        label = { Text("Amount") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        if (name.isNotBlank() && amount.toDoubleOrNull() != null) {
                           addSaleViewModel.addSales(name, amount.toDouble())

                            name = ""
                            amount = ""
                        }}, modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Add")

                    }//End Button

                }//End of column

            }//end of Surface
        }
    }


}