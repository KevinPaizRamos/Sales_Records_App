package com.example.hwrk3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
fun SaleListScreen(navController: NavHostController){


 val salesListVm = viewModel {
     SalesListVM(MyApp.salesRepository)
 }



    val users = salesListVm.salesList.value

    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }
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
    ) { padding ->
        Surface(
            modifier = Modifier.padding(20.dp),
            shape = RoundedCornerShape(10.dp),
            shadowElevation = 30.dp
        ) {
            Column(modifier = Modifier
                .padding(padding)
                .fillMaxWidth()) {
                DisplayHeading(heading = "Sales List")
                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    items(users){user-> UserItemOwnSurface(user = user)}
                }
            }
        }
    }
}