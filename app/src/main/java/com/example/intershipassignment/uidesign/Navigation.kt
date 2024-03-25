package com.example.intershipassignment.uidesign

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun navigationController(navController: NavHostController){
    NavHost(navController = navController, startDestination = "login"){
        composable("login"){
            loginScreen(Modifier,navController)
        }
        composable("create"){
            CreateAccountScreen(Modifier,navController)
        }
        composable("home"){
            homeScreen(Modifier,navController)
        }
        composable("employee"){
            empList(Modifier,navController)
        }
    }
}