package com.kickymaulana.belajarroomdatabase

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kickymaulana.belajarroomdatabase.userlist.PegawaiListScreen

@Composable
fun AppNavigation(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ){
        composable(route = "home"){
            PegawaiListScreen(navController)
        }

        composable(route = "create"){
            PegawaiCreateScreen()
        }

    }

}