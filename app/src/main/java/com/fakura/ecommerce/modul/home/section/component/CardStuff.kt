package com.fakura.ecommerce.modul.home.section.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fakura.ecommerce.model.Stuff
import com.fakura.ecommerce.resource.theme.hintColor
import com.fakura.ecommerce.resource.theme.primaryDarkColor


@Composable
fun StuffWidget(item: Stuff, first: Boolean, last: Boolean) {
    Card(modifier = Modifier
        .padding(
            start = if(first) 34.dp else 15.dp,
            top = 12.dp,
            bottom = 12.dp,
            end = if(last) 32.dp else 0.dp)
        .clickable {
            //Do Something
        },
        shape = RoundedCornerShape(corner = CornerSize(12.dp)),
        elevation = 6.dp) {
        Column {
            Image(
                painter = painterResource(id = item.image),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier.size(172.dp)
            )
            Text(text = item.title, fontWeight = FontWeight.Normal,
                color = Color.Black, fontSize = 14.sp,
                modifier = Modifier.padding(12.dp).width(140.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.width(160.dp)
            ) {
                Text(text = "Rp ${item.price}", fontWeight = FontWeight.Medium,
                    color = primaryDarkColor, fontSize = 12.sp,
                    modifier = Modifier
                        .padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
                )
                Text(text = "${(20..500).random()} Sold",
                    fontWeight = FontWeight.Normal, color = hintColor
                    , fontSize = 12.sp)
            }
        }
    }
}