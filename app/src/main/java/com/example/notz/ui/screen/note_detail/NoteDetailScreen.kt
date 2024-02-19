@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.notz.ui.screen.note_detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.notz.domain.states.NotesState
import com.example.notz.ui.screen.home.HomeViewModel
import com.example.notz.ui.screen.note_detail.components.NoteDetailAppBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NoteDetailScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel,
    noteIndex: Int?,
) {
    val appBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    val note = if (noteIndex == null) null else
        when (val notesState = homeViewModel.state.collectAsState().value) {
            is NotesState.Loaded -> notesState.notes[noteIndex]
            else -> null
        }

    Scaffold(
        topBar = {
            NoteDetailAppBar(
                noteTitle = note?.title ?: "",
                appBarScrollBehavior = appBarScrollBehavior,
                navController = navController,
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Column {
                Text(
                    text = note?.title ?: "", fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = note?.description ?: "", fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}