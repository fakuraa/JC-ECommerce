package com.fakura.ecommerce.model

import com.fakura.ecommerce.R

data class Category (var id: String,
var title:String,var image:Int
)

fun getCategorys(): List<Category> {
    return listOf(
        Category(
            id = "1",
            title = "Promo",
            image = R.drawable.voucher
        ),

        Category(
            id = "2",
            title = "Clothes",
            image = R.drawable.clothes
        ),

        Category(
            id = "3",
            title = "Furniture",
            image = R.drawable.furniture
        ),

        Category(
            id = "4",
            title = "Electronic",
            image = R.drawable.oven
        ),

        Category(
            id = "5",
            title = "Payment",
            image = R.drawable.payment_1
        ),

        Category(
            id = "6",
            title = "Sport",
            image = R.drawable.sport
        ),

        Category(
            id = "7",
            title = "Medicine",
            image = R.drawable.medicine
        ),
    )
}