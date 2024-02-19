@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.notz.ui.screen.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notz.domain.models.Note
import com.example.notz.domain.models.NoteTag
import com.example.notz.ui.navigation.NavigationItem


@Composable
fun NoteCard(
    note: Note,
    noteIndex: Int,
    bgColor: Color,
    navController: NavHostController
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        onClick = {
            navController.navigate(NavigationItem.NoteDetail.passNoteIndex(noteIndex))
        },
        colors = CardDefaults.cardColors(
            containerColor = bgColor,
        ),
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = note.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
//                maxLines = 3,
//                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = note.description,
                fontSize = 16.sp,
//                maxLines = 12,
//                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
//            Box(
//                modifier = Modifier
//                    .background(
//                        color = note.noteTag.color,
//                        shape = RoundedCornerShape(16.dp),
//                    )
//                    .padding(horizontal = 12.dp, vertical = 8.dp)
//            ) {
//                Text(
//                    text = "# ${note.noteTag}",
//                    fontSize = 14.sp,
//                )
//            }
//            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = note.createdAt,
                fontSize = 14.sp,
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview
@Composable
fun NoteCardPreview() {
    NoteCard(
        note = Note(
            title = "News PM Modi",
            description = "PM Modi goes to ayodhya",
            createdAt = "8 Jan 2024",
            lastEditedAt = "10 Jan 2024",
            noteTag = NoteTag.ToDo,
        ),
        noteIndex = 1,
        bgColor = Color(173, 216, 230),
        navController = rememberNavController(),
    )
}