package com.fakura.ecommerce.model

import com.fakura.ecommerce.R

data class Banner (var id: String,
var title:String,var image:Int
)

fun getBanners(): List<Banner> {
    return listOf(
        Banner(
            id = "tt0499549",
            title = "Avatar",
            image = R.drawable.banner_1
        ),

        Banner(
            id = "tt0416449",
            title = "300",
            image = R.drawable.banner_2
        ),

        Banner(
            id = "tt0848228",
            title = "The Avengers",
            image = R.drawable.banner_3
        ),

        Banner(
            id = "tt0993846",
            title = "The Wolf of Wall Street",
            image = R.drawable.banner_4
        ),

        Banner(
            id = "tt0816692",
            title = "Interstellar",
            image = R.drawable.banner_5
        ),
    )
}