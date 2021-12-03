package com.example.footyscores.presentation

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.footyscores.presentation.fixture_list.FixtureListScreen
import com.example.footyscores.presentation.fixture_list.TabScreens
import com.example.footyscores.presentation.ui.theme.FootyScoresTheme
import com.example.footyscores.presentation.ui.theme.Orange
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    @ExperimentalPagerApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FootyScoresTheme {
                val navController = rememberNavController()
                val items = listOf(
                    BottomNavItem("Scores", "fixture_list_screen", Icons.Default.SportsSoccer),
                    BottomNavItem("Favorite", "favorites_screen", Icons.Default.StarBorder),
                    BottomNavItem("Settings", "settings_screen", Icons.Default.Settings),
                )
                Scaffold(bottomBar = {
                    BottomNavigationBar(
                        items = items,
                        navController = navController,
                        onItemClick = { navController.navigate(it.route) }
                    )
                }) {
                    Screens(navController)
                }
            }
        }
    }
}


@ExperimentalMaterialApi
@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(modifier = modifier, backgroundColor = Color.Black, elevation = 0.dp) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                selectedContentColor = Orange,
                unselectedContentColor = Color.White,
                onClick = { onItemClick(item) },
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        if (item.badgeCount > 0) {
                            BadgeBox(
                                badgeContent = {
                                    Text(text = item.badgeCount.toString())
                                }
                            ) {
                                Icon(imageVector = item.icon, contentDescription = item.name)
                            }
                        } else {
                            Icon(imageVector = item.icon, contentDescription = item.name)

                        }

                        if (selected) {
                            Text(text = item.name, textAlign = TextAlign.Center, fontSize = 10.sp)
                        }
                    }
                }
            )
        }
    }

}

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun Screens(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screens.FixtureListScreen.route) {
        composable(Screens.FixtureListScreen.route) {
            TabScreens()
        }
        composable(Screens.FavoritesScreen.route) {

        }
        composable(Screens.SettingScreen.route) {

        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@ExperimentalFoundationApi
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    FootyScoresTheme(darkTheme = true) {
        FixtureListScreen(12345677L)
    }
}