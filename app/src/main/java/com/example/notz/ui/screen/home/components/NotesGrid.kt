@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.notz.ui.screen.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notz.core.notes
import com.example.notz.data.models.toModel
import com.example.notz.domain.states.NotesState
import com.example.notz.ui.theme.random

@Composable
fun HomeScreenBody(
    notesState: NotesState,
    navController: NavHostController
) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            text = "Recent Notes",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
        )
        Spacer(modifier = Modifier.height(8.dp))
        NotesList(notesState = notesState, navController = navController)
    }

}

@Composable
fun NotesList(notesState: NotesState, navController: NavHostController) {
    when (notesState) {
        NotesState.Initial -> Box {}
        NotesState.Loading -> Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(32.dp)
                    .align(Alignment.Center)
            )
        }

//        is NotesState.Loaded -> LazyColumn {
//            itemsIndexed(notesState.notes) { index, note ->
//                Box(
//                    modifier = Modifier.padding(bottom = 16.dp)
//                ) {
//                    NoteCard(
//                        note = note, noteIndex = index,
//                        bgColor = Color.Companion.random(),
//                        navController
//                    )
//                }
//            }
//        }

        is NotesState.Loaded -> LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            verticalItemSpacing = 8.dp,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            content = {
                itemsIndexed(notesState.notes) { index, note ->
                    NoteCard(
                        note = note, noteIndex = index,
                        bgColor = Color.Companion.random(),
                        navController
                    )
                }
            },
            modifier = Modifier.fillMaxSize()
        )

        is NotesState.Error -> Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Something Went Wrong",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
            )
        }
    }
}

@Preview
@Composable
fun NotesListPreview() {
    NotesList(
        notesState = NotesState.Loaded(notes.map { it.toModel() }.toList()),
        navController = rememberNavController()
    )
}
