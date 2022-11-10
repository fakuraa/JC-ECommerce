package com.fakura.ecommerce.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.fakura.ecommerce.modul.details.DetailsScreen
import com.fakura.ecommerce.modul.home.HomeScreen
import com.fakura.ecommerce.modul.splashscreen.SplashScreen


@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController= navController,
        startDestination = Routes.SplashScreen.name
    ){
        composable(Routes.SplashScreen.name){
            // here we pass where this should lead us to
            SplashScreen(navController = navController)
        }
        composable(Routes.HomeScreen.name){
            // here we pass where this should lead us to
            HomeScreen(navController = navController)
        }

//        composable(Routes.DetailsScreen.name+"/{movie}",
//            arguments = listOf(navArgument(name = "movie"){type = NavType.StringType}
//            )){ backStackEntry->
//            DetailsScreen(navController = navController,
//                backStackEntry.arguments?.getString("movie"))
//        }
    }
}