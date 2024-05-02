package com.example.notz.ui.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.notz.ui.screen.home.components.HomeScreenAppBar
import com.example.notz.ui.screen.home.components.HomeScreenBody

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
    onNavigateToNoteAddEdit: (noteIndex: Int?) -> Unit,
) {
    val notesState = homeViewModel.state.collectAsState().value

    Scaffold(
        topBar = {
            HomeScreenAppBar()
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                onNavigateToNoteAddEdit(null)
//                homeViewModel.getNotes()
            }) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Add",
                    modifier = Modifier.size(28.dp)
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                HomeScreenBody(
                    notesState = notesState,
                    onNavigateToNoteAddEdit = onNavigateToNoteAddEdit,
                )
            }
        }
    )
}

@Preview
@Composable
fun HomeScreePreview() {
    HomeScreen(
        homeViewModel = hiltViewModel<HomeViewModel>(),
        onNavigateToNoteAddEdit = {},
    )
}

