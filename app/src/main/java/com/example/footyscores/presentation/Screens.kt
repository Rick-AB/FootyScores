package com.example.footyscores.presentation

sealed class Screens(val name: String, val arguments: String?) {
    object FixtureListScreen: Screens("fixture_list_screen", null)
    object FixtureDetailsScreen: Screens("fixture_details_screen", "/{fixtureId}/{homeTeamName}/{homeTeamLogo}/{awayTeamName}/{awayTeamLogo}/{date}/{time}")
    object FavoritesScreen: Screens("favorites_screen", null)
    object SettingScreen: Screens("settings_screen", null)

    fun buildRoute(name: String, vararg arguments: String): String {
        var route = name
        arguments.forEach {
            route += "/$it"
        }
        return route
    }
}
