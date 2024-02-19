package com.example.notz.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.notz.ui.screen.home.HomeScreen
import com.example.notz.ui.screen.home.HomeViewModel
import com.example.notz.ui.screen.note_detail.NoteDetailScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Home.route,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(NavigationItem.Home.route) {
            val homeViewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(navController = navController, homeViewModel = homeViewModel)
        }

        composable(
            NavigationItem.NoteDetail.route,
            arguments = listOf(navArgument("noteIndex") {
                type = NavType.IntType
            })
        ) {backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(NavigationItem.Home.route)
            }
            val homeViewModel = hiltViewModel<HomeViewModel>(parentEntry)
            NoteDetailScreen(
                navController = navController,
                homeViewModel = homeViewModel,
                noteIndex = backStackEntry.arguments?.getInt("noteIndex")
            )
        }
    }
}