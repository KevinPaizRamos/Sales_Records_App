package com.example.hwrk3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun DisplayHeading(heading:String){
    Text(
        heading,
        modifier = Modifier.padding(6.dp),
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary,
        style = MaterialTheme.typography.headlineMedium
    )

}// end of DisplayHeading@Composable
@Composable
fun DisplayNormalText(text:String){

    Text(text, modifier = Modifier.padding(1.dp) ,color = Color.Magenta, style = MaterialTheme.typography.bodyLarge)

}// end of DisplayNormalText
@Composable
fun UserItemOwnSurface(user:User){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),


        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 20.dp
        )

    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),


        ) {DisplayNormalText(user.name) // Presuming this is a styled Text composable
                        Text(text=user.amount.toString())// Presuming this is a styled Text composable

        }
    }

}