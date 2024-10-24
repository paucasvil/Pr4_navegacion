package com.example.practicanavegacion.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.practicanavegacion.components.MainButton
import com.example.practicanavegacion.components.TitleBar
import com.example.practicanavegacion.components.Space
import com.example.practicanavegacion.components.TitleView
import com.example.practicanavegacion.components.MainIconButton


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Menu(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "HOME PAGE") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Blue
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    ) {
        ContentMenuView(navController)
    }
}
@Composable
fun ContentMenuView(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "Menu")
        Space()
        MainButton(name = "Descuentos", backColor = Color.Blue, color = Color.White) {
            navController.navigate("Descuentos")
        }
        Space()
        MainButton(name = "DogYear", backColor = Color.Blue, color = Color.White) {
            navController.navigate("DogYear")
        }
        Space()
        MainButton(name = "Loteria", backColor = Color.Blue, color = Color.White) {
            navController.navigate("Loteria")
        }
    }
}