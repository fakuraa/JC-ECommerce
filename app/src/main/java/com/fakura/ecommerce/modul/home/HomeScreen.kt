package com.fakura.ecommerce.modul.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fakura.ecommerce.model.getCategorys
import com.fakura.ecommerce.modul.home.section.body.CategoryWidget
import com.fakura.ecommerce.modul.home.section.body.FlashSaleWidget
import com.fakura.ecommerce.modul.home.section.body.TopProductWidget
import com.fakura.ecommerce.modul.home.section.header.AppBar
import com.fakura.ecommerce.modul.home.section.header.Banner
import com.fakura.ecommerce.resource.theme.ECommerceTheme
import com.fakura.ecommerce.resource.theme.backgroundColor
import com.fakura.ecommerce.resource.theme.whiteColor


@Composable
fun HomeScreen(navController: NavController){
    ECommerceTheme{
        Scaffold (){
            Surface(color = backgroundColor,
                modifier = Modifier.padding(it)) {
                BoxWithConstraints (
                    modifier =Modifier
                        .background(color = backgroundColor)
                ){
                    val boxWidth = this.maxWidth
                    Box (
                        modifier = Modifier
                            .width(boxWidth)
                            .padding(top = 60.dp)
                            .background(backgroundColor)){
                        MainContent(navController = navController)
                    }
                    //AppBar
                    AppBar()
                }
            }
        }
    }
}

@Composable
fun MainContent(navController: NavController){
    LazyColumn (modifier = Modifier.background(whiteColor)){
        item { Banner() }
        item {
            LazyRow {
                items(items = getCategorys() ){
                    CategoryWidget(it)
                }
            }
        }
        item {Spacer(Modifier.height(6.dp))}
        item{
           FlashSaleWidget()
        }
        item{
            TopProductWidget()
        }
    }
}
