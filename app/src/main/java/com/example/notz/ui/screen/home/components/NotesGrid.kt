package com.example.notz.ui.screen.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notz.R
import com.example.notz.core.notes
import com.example.notz.data.models.api_dto.toModel
import com.example.notz.domain.states.NotesState

@Composable
fun NotesGrid(
    notesState: NotesState,
    onNavigateToNoteAddEdit: (noteIndex: Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier.fillMaxSize()) {
        when (notesState) {
            NotesState.Initial -> Box {}
            NotesState.Loading -> CircularProgressIndicator(
                modifier = Modifier
                    .size(32.dp)
                    .align(Alignment.Center)
            )

            is NotesState.Loaded ->
                if (notesState.notes.isEmpty())
                    Box(
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            stringResource(R.string.start_adding_notes),
                            fontSize = 22.sp,
                        )
                    }
                else
                    LazyVerticalStaggeredGrid(
                        columns = StaggeredGridCells.Fixed(2),
                        verticalItemSpacing = 8.dp,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        content = {
                            itemsIndexed(notesState.notes) { index, note ->
                                NoteCard(
                                    note = note, noteIndex = index,
                                    onNavigateToNoteAddEdit = onNavigateToNoteAddEdit,
                                )
                            }
                        },
                    )

            is NotesState.Error ->
                Text(
                    text = stringResource(R.string.something_went_wrong),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                )

        }
    }
}

@Preview
@Composable
fun NotesGridPreview() {
    NotesGrid(
        notesState = NotesState.Loaded(notes.map { it.toModel() }.toList()),
        onNavigateToNoteAddEdit = {},
    )
}
