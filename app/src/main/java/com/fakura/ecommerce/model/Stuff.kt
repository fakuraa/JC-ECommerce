package com.fakura.ecommerce.model

import com.fakura.ecommerce.R

data class Stuff (var id: String,
var title:String,
var price:String,
var category:String,
var image:Int
)

fun getStuffs(): ArrayList<Stuff> {
    return arrayListOf(
        Stuff(
            id = "1",
            title = "nike Air Jordan",
            price = "2.500.000",
            category = "shoes|fashion",
            image = R.drawable.stuff_air_jordan
        ),

        Stuff(
            id = "2",
            title = "Bag Midnight",
            price = "550.000",
            category = "fashion",
            image = R.drawable.stuff_bag
        ),

        Stuff(
            id = "3",
            title = "Tote bag",
            price = "120.000",
            category = "fashion",
            image = R.drawable.stuff_bag1
        ),

        Stuff(
            id = "4",
            title = "Ameli Bag",
            price = "1.500.000",
            category = "fashion",
            image = R.drawable.stuff_bag2
        ),

        Stuff(
            id = "5",
            title = "Sony Camera",
            price = "7.500.000",
            category = "electronic|camera",
            image = R.drawable.stuff_camera
        ),

        Stuff(
            id = "6",
            title = "Canon camera",
            price = "9.900.000",
            category = "electronic|camera",
            image = R.drawable.stuff_camera1
        ),

        Stuff(
            id = "7",
            title = "Camera",
            price = "6.500.000",
            category = "electronic|camera",
            image = R.drawable.stuff_camera2
        ),
        Stuff(
            id = "8",
            title = "Apple Watch",
            price = "3.500.000",
            category = "electronic|watch",
            image = R.drawable.stuff_apple_watch
        ),
        Stuff(
            id = "9",
            title = "Iphone 11 Pro",
            price = "12.500.000",
            category = "electronic|phone",
            image = R.drawable.stuff_iphone11pro
        ),
        Stuff(
            id = "10",
            title = "Iphone 13 Pro Max",
            price = "14.500.000",
            category = "electronic|phone",
            image = R.drawable.stuff_iphone13pro
        ),

        Stuff(
            id = "11",
            title = "Simple Keyboard",
            price = "200.000",
            category = "electronic|keyboard",
            image = R.drawable.stuff_keyboard
        ),
        Stuff(
            id = "12",
            title = "Keyboard",
            price = "250.000",
            category = "electronic|keyboard",
            image = R.drawable.stuff_keyboard1
        ),
        Stuff(
            id = "13",
            title = "MI 11",
            price = "5.500.000",
            category = "electronic|phone",
            image = R.drawable.stuff_mi11
        ),
        Stuff(
            id = "14",
            title = "Macbook pro",
            price = "7.500.000",
            category = "electronic|laptop",
            image = R.drawable.stuff_macbook_pro_2012
        ),
        Stuff(
            id = "15",
            title = "Macbook Pro 2020",
            price = "12.500.000",
            category = "electronic|laptop",
            image = R.drawable.stuff_macbook_pro_2020
        ),
        Stuff(
            id = "16",
            title = "Nike black",
            price = "2.200.000",
            category = "shoes|fashion",
            image = R.drawable.stuff_nike_black
        ),
        Stuff(
            id = "17",
            title = "Nike",
            price = "1.500.000",
            category = "shoes|fashion",
            image = R.drawable.stuff_nikey
        ),
    )
}