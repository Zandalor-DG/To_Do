package com.example.to_do.navigation

sealed class Destinations(
  val route: String,
  val objectName: String? = null,
  val objectPath: String? = null
) {
  // Auth feature
  object Login : Destinations("login")
  object Registration : Destinations("registration")

  // Home feature
  object Home : Destinations("home")

  // Profile feature
  object Profile : Destinations("profile")

  // Dynamic destinations
  object Details : Destinations(
    route = "details",
    objectName = "id",
    objectPath = "/{id}"
  ) {
    fun createRoute(id: String) = "details/$id"
  }
}