package com.example.footyscores.presentation

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.footyscores.presentation.fixture_details.FixtureDetailsFragment
import com.example.footyscores.presentation.fixture_list.FixtureListViewModel
import com.example.footyscores.presentation.fixture_list.TabScreens
import com.example.footyscores.presentation.ui.theme.FootyScoresTheme
import com.example.footyscores.presentation.ui.theme.Orange
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FootyScoresTheme {
                val navController = rememberNavController()
                val mainViewModel: FixtureListViewModel =
                    viewModel(LocalContext.current as ComponentActivity)
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
                                if (it.name == "Refresh") {
                                    mainViewModel.refreshData()
                                } else {
                                    navController.navigate(it.route)
                                }
                            },
                            isRefreshing = mainViewModel.state.value.isRefreshing
                        )
                    }
                }) { padding ->
                    Screens(navController, mainViewModel, padding)
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
    onItemClick: (BottomNavItem) -> Unit,
    isRefreshing: Boolean
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
                        if (item.name == "Refresh") {
                            val currentRotation = remember {
                                mutableStateOf(0f)
                            }
                            val transition = rememberInfiniteTransition()
                            if (isRefreshing) {
                                currentRotation.value = transition.animateFloat(
                                    initialValue = 0f,
                                    targetValue = 360f,
                                    animationSpec = InfiniteRepeatableSpec(
                                        animation = tween(2000),
                                        repeatMode = RepeatMode.Restart
                                    )
                                ).value
                            }
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.name,
                                modifier = Modifier.rotate(currentRotation.value)
                            )
                        } else {
                            Icon(imageVector = item.icon, contentDescription = item.name)
                        }
                        Text(text = item.name, textAlign = TextAlign.Center, fontSize = 10.sp)
                    }
                }
            )
        }
    }

}

@Composable
fun Screens(
    navController: NavHostController,
    mainViewModel: FixtureListViewModel,
    innerPadding: PaddingValues
) {
    NavHost(navController = navController, startDestination = Screens.FixtureListScreen.name) {
        composable(Screens.FixtureListScreen.name) {
            TabScreens(navController, mainViewModel, innerPadding)
        }
        composable(Screens.FavoritesScreen.name) {

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

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    FootyScoresTheme(darkTheme = true) {
//        FixtureListScreen(12345677L, )
    }
}