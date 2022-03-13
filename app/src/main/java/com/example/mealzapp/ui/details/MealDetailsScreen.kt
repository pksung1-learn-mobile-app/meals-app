package com.example.mealzapp.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.transform.CircleCropTransformation
import com.example.mealzapp.model.response.MealResponse

@Composable
fun MealDetailsScreen(meal: MealResponse?) {
    Column() {
        Row() {
            Card() {
                Image(
                    painter = rememberAsyncImagePainter(model = meal?.imageURL),
                    contentDescription = meal?.name,
                    modifier = Modifier.size(200.dp)
                )
                Text(meal?.name ?: "NO NAME")
            }
        }
        Button(onClick = {}) {
            Text("Change State of meal profile picture")
        }
    }
}