package com.example.notz.ui.screen.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notz.domain.states.NotesState

@Composable
fun HomeScreenBody(
    notesState: NotesState,
    onNavigateToNoteAddEdit: (noteIndex: Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.padding(horizontal = 16.dp)) {
        Text(
            text = "Recent Notes",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
        )
        Spacer(modifier = Modifier.height(8.dp))
        NotesGrid(
            notesState = notesState,
            onNavigateToNoteAddEdit = onNavigateToNoteAddEdit,
        )
    }
}