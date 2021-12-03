package com.example.footyscores.presentation

sealed class Screens(val route: String) {
    object FixtureListScreen: Screens("fixture_list_screen")
    object FixtureDetailsScreen: Screens("fixture_details_screen")
    object FavoritesScreen: Screens("favorites_screen")
    object SettingScreen: Screens("settings_screen")
}
