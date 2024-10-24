package com.example.practicanavegacion.navigation

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.practicanavegacion.viewModels.LoteriaViewModel
import com.example.practicanavegacion.views.AñosPerrunos
import com.example.practicanavegacion.views.Menu
import com.example.practicanavegacion.views.Descuentos
import com.example.practicanavegacion.views.DogYear
import com.example.practicanavegacion.views.Loteria


@Composable
fun NavManager(viewModels:LoteriaViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home"  ){
        composable("Home"){
            Menu(navController)
        }
        composable("DogYear"){
            DogYear(navController)
        }
        composable("Loteria"){
            Loteria(navController,  viewModels = viewModels)
        }
        composable("Descuentos"){
            Descuentos(navController)
        }
    }
}