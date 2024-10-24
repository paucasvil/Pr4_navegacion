package com.example.practicanavegacion.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practicanavegacion.components.BotonReutilizable
import com.example.practicanavegacion.components.DosTarjetas
import com.example.practicanavegacion.components.MainButton
import com.example.practicanavegacion.components.MainIconButton
import com.example.practicanavegacion.components.Space
import com.example.practicanavegacion.components.SpaceH
import com.example.practicanavegacion.components.TextFields
import com.example.practicanavegacion.components.TitleBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Descuentos(navController: NavController)
{
    Scaffold(
        topBar={
            TopAppBar(
                title = { TitleBar(name = "DESCUENTOS") },
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

    )
    {
        ContentHomeView(it, navController)
    }
}

@Composable
fun ContentHomeView(paddingValues: PaddingValues, navController: NavController)
{
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        var precio by remember { mutableStateOf("") }
        var descuento by remember { mutableStateOf("") }
        var precioTotal by remember { mutableStateOf("") }
        var descuentoTotal by remember { mutableStateOf("") }
        DosTarjetas(titulo1 = "Total", numero1 = precioTotal, titulo2 = "Descuento", numero2 = descuentoTotal)
        TextFields(value = precio, onValueChange = {precio = it}, label = "")
        SpaceH()
        TextFields(value = descuento, onValueChange = {descuento = it}, label = "")
        SpaceH(10.dp)
        BotonReutilizable(text = "Calcular") {
            descuentoTotal=(precio.toDouble() * descuento.toDouble() / 100).toString()
            precioTotal = (precio.toDouble() - descuentoTotal.toDouble()).toString()
        }
        Space()
        Space()
        MainButton(name = "Home", backColor = Color.Blue, color = Color.White) {
            navController.popBackStack()
        }
    }
}