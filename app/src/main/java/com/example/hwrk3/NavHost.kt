package com.example.hwrk3

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun nav(){
    val navController = rememberNavController()

    NavHost(navController=navController, startDestination = "SaleListScreen"){
        composable(route="SaleListScreen"){
            SaleListScreen(navController)
        }
        composable(route="AddSaleScreen"){
            AddSaleScreen(navController)
        }

    }
}