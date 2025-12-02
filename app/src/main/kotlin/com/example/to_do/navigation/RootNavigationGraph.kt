package com.example.to_do.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.to_do.ui.home_screen.HomeScreen

@Composable
fun RootNavigationGraph(
  navController: NavHostController,
  innerPadding: PaddingValues,
  startDestination: String = Destinations.Home.route,
) {
  NavHost(
    navController = navController,
    startDestination = startDestination
  ) {
//    // Auth feature
//    composable(Destinations.Login.route) {
//      LoginScreen(
//        onLoginSuccess = {
//          navController.navigate(Destinations.Home.route) {
//            popUpTo(Destinations.Login.route) { inclusive = true }
//          }
//        },
//        onNavigateToRegistration = {
//          navController.navigate(Destinations.Registration.route)
//        }
//      )
//    }
//
//    composable(Destinations.Registration.route) {
//      RegistrationScreen(
//        onRegistrationSuccess = {
//          navController.navigate(Destinations.Home.route) {
//            popUpTo(Destinations.Login.route) { inclusive = true }
//          }
//        },
//        onNavigateToLogin = {
//          navController.popBackStack()
//        }
//      )
//    }

    // Home feature
    composable(Destinations.Home.route) {
      HomeScreen(innerPadding)
    }

//    // Profile feature
//    composable(Destinations.Profile.route) {
//      ProfileScreen(
//        onBackClick = {
//          navController.popBackStack()
//        }
//      )
//    }
//
//    // Details with parameter
//    composable(
//      route = Destinations.Details.route + Destinations.Details.objectPath,
//      arguments = listOf(navArgument("id") { type = NavType.StringType })
//    ) { backStackEntry ->
//      val id = backStackEntry.arguments?.getString("id") ?: ""
//      DetailsScreen(
//        id = id,
//        onBackClick = {
//          navController.popBackStack()
//        }
//      )
//    }
  }
}