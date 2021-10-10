package com.fahmy.presentation.ui.city.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.fahmy.domain.model.City

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CityItem(
    city: City,
    onItemClick: (City) -> Unit,
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 15.dp,
        onClick = { onItemClick(city) }
    ) {
        Column() {

            Image(
                painter = rememberImagePainter(city.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.Crop,
            )

            Text(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(12.dp),
                text = city.name,
                color = MaterialTheme.colors.onSurface,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            city.description?.let {

                Text(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(12.dp)
                        .background(
                            color = MaterialTheme.colors.primary,
                            shape = RoundedCornerShape(5.dp)
                        )
                        .padding(
                            start = 24.dp,
                            end = 24.dp,
                            top = 8.dp,
                            bottom = 8.dp
                        ),

                    text = it,
                    fontSize = 17.sp
                )


            }


        }


    }
}