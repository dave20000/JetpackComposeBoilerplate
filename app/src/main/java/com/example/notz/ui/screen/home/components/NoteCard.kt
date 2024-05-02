package com.example.notz.ui.screen.home.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notz.domain.models.Note
import com.example.notz.domain.models.NoteTag

@Composable
fun NoteCard(
    note: Note,
    noteIndex: Int,
    onNavigateToNoteAddEdit: (noteIndex: Int) -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    if (isPressed) {

        //Use if + DisposableEffect to wait for the press action is completed
        DisposableEffect(Unit) {
            onDispose {
                println("released")
            }
        }
    }

//    val extraPadding by animateDpAsState(
//        if (isPressed) 12.dp else 16.dp,
//        label = "Extra Padding",
//        animationSpec = spring(
//            dampingRatio = Spring.DampingRatioMediumBouncy,
//            stiffness = Spring.StiffnessLow
//        )
//    )

    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.9f else 1.0f,
        label = "Scale Animation",
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        onClick = {
            onNavigateToNoteAddEdit(noteIndex)
        },
        interactionSource = interactionSource,
        colors = CardDefaults.cardColors(),
        modifier = Modifier.scale(scale.coerceAtLeast(0.8f))
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            if (note.title.isNotEmpty())
                Text(
                    text = note.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
//                maxLines = 3,
//                overflow = TextOverflow.Ellipsis,
                )
            if (note.title.isNotEmpty())
                Spacer(modifier = Modifier.height(8.dp))
            if (note.description.isNotEmpty())
                Text(
                    text = note.description,
                    fontSize = 16.sp,
//                maxLines = 12,
//                overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            if (note.description.isNotEmpty())
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
        }
    }
}

@Preview
@Composable
fun NoteCardPreview() {
    NoteCard(
        note = Note(
            id = 0,
            title = "News PM Modi",
            description = "PM Modi goes to ayodhya",
            createdAt = "8 Jan 2024",
            lastEditedAt = "10 Jan 2024",
            noteTag = NoteTag.ToDo,
        ),
        noteIndex = 1,
        onNavigateToNoteAddEdit = {}
    )
}