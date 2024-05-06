package com.example.notz.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
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
import com.example.notz.ui.screen.note_add_edit.NoteAddEditScreen

@RequiresApi(Build.VERSION_CODES.O)
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
            HomeScreen(
                homeViewModel = homeViewModel,
                onNavigateToNoteAddEdit = { noteIndex: Int? ->
                    if (noteIndex != null) {
                        navController.navigate(NavigationItem.NoteAddEdit.passNoteIndex(noteIndex))
                    } else {
                        navController.navigate(NavigationItem.NoteAddEdit.route)
                    }
                }
            )
        }

        composable(
            NavigationItem.NoteAddEdit.route,
        ) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(NavigationItem.Home.route)
            }
            val homeViewModel = hiltViewModel<HomeViewModel>(parentEntry)
            NoteAddEditScreen(
                navController = navController,
                homeViewModel = homeViewModel,
                noteIndex = null
            )
        }

        composable(
            NavigationItem.NoteAddEdit.EDIT_ROUTE,
            arguments = listOf(navArgument("noteIndex") {
                type = NavType.IntType
            }),
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        300, easing = LinearEasing,
                    )
                ) + slideIntoContainer(
                    animationSpec = tween(300, easing = EaseIn),
                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        300, easing = LinearEasing
                    )
                ) + slideOutOfContainer(
                    animationSpec = tween(300, easing = EaseOut),
                    towards = AnimatedContentTransitionScope.SlideDirection.End
                )
            }
        ) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(NavigationItem.Home.route)
            }
            val homeViewModel = hiltViewModel<HomeViewModel>(parentEntry)
            NoteAddEditScreen(
                navController = navController,
                homeViewModel = homeViewModel,
                noteIndex = backStackEntry.arguments?.getInt("noteIndex")
            )
        }
    }
}