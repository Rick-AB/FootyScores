package com.example.footyscores.presentation

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.example.footyscores.presentation.fixture_details.FixtureDetailsFragment
import com.example.footyscores.presentation.fixture_list.TabScreens
import com.example.footyscores.presentation.ui.theme.FootyScoresTheme
import com.example.footyscores.presentation.ui.theme.Orange
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FootyScoresTheme {
                val navController = rememberNavController()
                val bottomBarItems = listOf(
                    BottomNavItem("Scores", "fixture_list_screen", Icons.Default.SportsSoccer),
                    BottomNavItem("Favorite", "favorites_screen", Icons.Default.StarBorder),
                    BottomNavItem("Refresh", "", Icons.Default.Refresh),
                )
                Scaffold(bottomBar = {
                    val currentRoute =
                        navController.currentBackStackEntryAsState().value?.destination?.route
                    if (bottomBarItems.map { it.route }.contains(currentRoute)) {
                        BottomNavigationBar(
                            items = bottomBarItems,
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                }) { padding ->
                    Screens(navController, padding)
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
                onClick = {
                    if (item.route.isEmpty()) {
                        return@BottomNavigationItem
                    } else {
                        onItemClick(item)
                    }
                },
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        if (item.badgeCount > 0) {
                            BadgedBox(
                                badge = {
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

@OptIn(ExperimentalCoilApi::class)
@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun Screens(
    navController: NavHostController,
    innerPadding: PaddingValues
) {
    NavHost(navController = navController, startDestination = Screens.FixtureListScreen.name) {
        composable(Screens.FixtureListScreen.name) {
            TabScreens(navController, innerPadding)
        }
        composable(Screens.FavoritesScreen.name) {

        }
        composable(Screens.SettingScreen.name) {

        }
        composable(
            Screens.FixtureDetailsScreen.name + Screens.FixtureDetailsScreen.arguments,
            arguments = listOf(
                navArgument("fixtureId") { type = NavType.IntType },
                navArgument("homeTeamName") { type = NavType.StringType },
                navArgument("homeTeamLogo") { type = NavType.StringType },
                navArgument("awayTeamName") { type = NavType.StringType },
                navArgument("awayTeamLogo") { type = NavType.StringType },
                navArgument("date") { type = NavType.StringType },
                navArgument("time") { type = NavType.StringType }
            )
        ) {
            val fixtureId = it.arguments?.getInt("fixtureId", 0)
            val homeTeamName = it.arguments?.getString("homeTeamName", "")
            val homeTeamLogo = it.arguments?.getString("homeTeamLogo", "")
            val awayTeamName = it.arguments?.getString("awayTeamName", "")
            val awayTeamLogo = it.arguments?.getString("awayTeamLogo", "")
            val date = it.arguments?.getString("date", "")
            val time = it.arguments?.getString("time", "")
            FixtureDetailsFragment(
                navController = navController,
                fixtureId = fixtureId!!,
                homeTeamName = homeTeamName!!,
                homoTeamLogo = homeTeamLogo!!,
                awayTeamName = awayTeamName!!,
                awayTeamLogo = awayTeamLogo!!,
                date = date!!,
                time = time!!
            )
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
//        FixtureListScreen(12345677L, )
    }
}