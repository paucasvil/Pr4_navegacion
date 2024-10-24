package com.example.practicanavegacion.views

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.practicanavegacion.R
import com.example.practicanavegacion.components.MainButton
import com.example.practicanavegacion.components.MainIconButton
import com.example.practicanavegacion.components.Space
import com.example.practicanavegacion.components.TitleBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DogYear(navController: NavController)
{
    Scaffold(
        topBar={
            TopAppBar(
                title = { TitleBar(name = "AÑOS PERRUNOS") },
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
        AñosPerrunos(navController)
    }

}
@Composable
fun AñosPerrunos(navController: NavController, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val image = painterResource(id = R.drawable.dog)

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var age by remember { mutableStateOf(TextFieldValue("")) }
        var answer by remember { mutableStateOf(TextFieldValue("")) }
        Space()
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(
                    top = 100.dp
                )
        )
        Text(
            text = "Mis Años Perrunos",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            modifier = modifier.padding(16.dp)
        )
        OutlinedTextField(
            value = age,
            label = { Text(text = "Mi edad humana") },
            onValueChange = {
                age = it
            },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(
                    bottom = 20.dp,
                    top = 20.dp,
                )
        )
        ElevatedButton(
            onClick = {
                try {
                    val res = age.text.toInt() * 7
                    answer = TextFieldValue(res.toString())
                } catch (e: NumberFormatException) {
                    Toast.makeText(context, "Carácter inválido, ingresa un digito", Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text("Calcular")
        }
        OutlinedTextField(
            value = answer,
            readOnly = true,
            onValueChange = { answer = it },
            label = { Text("Edad perruna") },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(
                    bottom = 20.dp,
                    top = 20.dp,
                )
        )

        ElevatedButton(
            onClick = {
                age = TextFieldValue("")
                answer = TextFieldValue("")
            }
        ) {
            Text("Borrar")
        }
        Space()
        Space()
        MainButton(name = "Home", backColor = Color.Blue, color = Color.White) {
            navController.popBackStack()
        }
    }
}

