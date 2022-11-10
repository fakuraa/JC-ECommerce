package com.fakura.ecommerce.navigation


enum class Routes {
    SplashScreen,
    HomeScreen;
    companion object{
        fun fromRoute(route:String?):Routes
                = when(route?.substringBefore("/")){
            SplashScreen.name -> SplashScreen
            HomeScreen.name -> HomeScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognize")
        }
    }
}