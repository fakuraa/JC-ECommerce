package com.fakura.ecommerce.modul.home.section.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fakura.ecommerce.R
import com.fakura.ecommerce.resource.theme.ECommerceTheme

@Composable
@Preview
fun Chips(
    text: String = "All",
    imageId: Int = R.drawable.ic_like,
    selected: Boolean = true,
    modifier: Modifier = Modifier,
    first: Boolean =true,
    last: Boolean = false,
    onClick:()->Unit={},
) {
        // define properties to the chip
        // such as color, shape, width
    ECommerceTheme {
        Surface(
            color = when {
                selected -> MaterialTheme.colors.primary
                else -> Color.White
            },
            contentColor = when {
                selected -> MaterialTheme.colors.onPrimary
                else -> Color.LightGray
            },
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(
                width = 1.dp,
                color = when {
                    selected -> MaterialTheme.colors.primary
                    else -> Color.LightGray
                }
            ),
            modifier = modifier.padding(
                start = if(first) 34.dp else 15.dp,
                top = 12.dp,
                bottom = 12.dp,
                end = if(last) 32.dp else 0.dp).clickable {
                onClick()
            }
        ) {
            // Inside a Row pack the Image and text together to
            // show inside the chip
            Row(modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)) {
                Image(
                    painter = painterResource(imageId),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(20.dp)
                        .clip(CircleShape),
                    colorFilter = ColorFilter.tint(
                        when {
                            selected -> MaterialTheme.colors.onPrimary
                            else -> Color.LightGray
                        }
                    )
                )
                Text(
                    text = text,
                    style = typography.body2,
                    modifier = Modifier.padding(
                        end = 8.dp, top = 8.dp, bottom = 8.dp
                    )
                )
            }
        }
    }
    }