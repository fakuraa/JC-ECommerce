package com.fakura.ecommerce.model

import com.fakura.ecommerce.R

data class Trend (var id: String,
var title:String,var image:Int
)

fun getTrends(): List<Trend> {
    return listOf(
        Trend(
            id = "1",
            title = "All",
            image = R.drawable.ic_like
        ),

        Trend(
            id = "2",
            title = "Fashion",
            image = R.drawable.clothes
        ),

        Trend(
            id = "3",
            title = "Electronic",
            image = R.drawable.oven
        ),

        Trend(
            id = "4",
            title = "Shoes",
            image = R.drawable.ic_shoes
        ),

        Trend(
            id = "5",
            title = "camera",
            image = R.drawable.ic_camera
        ),

        Trend(
            id = "6",
            title = "keyboard",
            image = R.drawable.ic_keyboard
        ),
        Trend(
            id = "7",
            title = "Laptop",
            image = R.drawable.ic_laptop
        ),

        Trend(
            id = "8",
            title = "Phone",
            image = R.drawable.ic_phone
        ),
    )
}