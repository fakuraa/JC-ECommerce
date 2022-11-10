package com.fakura.ecommerce.modul.home.section.header

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fakura.ecommerce.resource.theme.Red
import com.fakura.ecommerce.resource.theme.hintColor
import com.fakura.ecommerce.resource.theme.primaryColor
import com.fakura.ecommerce.resource.theme.whiteColor

@Composable
@Preview
fun AppBar() {
    var search by remember {
        mutableStateOf("")
    }
    Box(modifier = Modifier.background(primaryColor)) {
        Row(
            Modifier
                .padding(12.dp)
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            OutlinedTextField(
                value = search,
                onValueChange = { search = it },
                singleLine = true,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Search,
                        contentDescription = "Search",
                        modifier = Modifier.size(24.dp),
                        hintColor
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.Black,
                    textColor = Color.Black
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                placeholder = { Text("Search...", color = hintColor) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(onClick = {}) {
                MyBadgeBox(
                    badge = {
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier.size(26.dp)
                        )
                    }, notification = true, counter = "3"
                )
            }

            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Outlined.ShoppingCart, contentDescription = "",
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
private fun MyBadgeBox(
    badge: @Composable () -> Unit,
    notificationRadius: Dp = 10.dp,
    notification: Boolean,
    counter:String = ""
) {

    Box {
        Box(modifier = Modifier.padding(notificationRadius)) {
            badge()
        }

        Box(
            modifier = if (notification) Modifier
                .padding(notificationRadius / 5)
                .align(Alignment.TopEnd)
                .size(notificationRadius * 2)
                .drawBehind {
                    drawCircle(Red)
                } else Modifier){
            Text(counter,
                modifier = Modifier.align(Alignment.Center),
                fontSize = 12.sp,
                color = whiteColor
            )
        }
    }
}