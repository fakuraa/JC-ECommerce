package com.fakura.ecommerce.modul.home.section.body

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fakura.ecommerce.model.Category


@Composable
fun CategoryWidget(category: Category) {
            Box {
                Column (Modifier.align(Alignment.Center)
                    .padding(
                        start = if(category.id=="1") 34.dp else 35.dp,
                        top = 12.dp,
                        bottom = 12.dp,
                    end = if(category.id=="7") 32.dp else 0.dp
                    ),
                    horizontalAlignment =Alignment.CenterHorizontally
                ){
                    Image(
                        painter = painterResource(category.image),
                        contentScale = ContentScale.Crop,
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(modifier = Modifier.size(11.dp))
                    Text(
                        category.title,
                        color = Color.Gray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
}