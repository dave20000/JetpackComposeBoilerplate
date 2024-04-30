@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.notz.ui.screen.note_add_edit

import android.os.Build
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.notz.domain.models.Note
import com.example.notz.domain.models.NoteTag
import com.example.notz.domain.states.NotesState
import com.example.notz.ui.componenets.NotzIconButton
import com.example.notz.ui.screen.home.HomeViewModel
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteAddEditScreen(
    navController: NavController,
    homeViewModel: HomeViewModel,
    noteIndex: Int?,
) {
//    var focusRequester = remember {
//        FocusRequester()
//    }

    val note = if (noteIndex == null) null else
        when (val notesState = homeViewModel.state.collectAsState().value) {
            is NotesState.Loaded ->
                if (notesState.notes.isEmpty()) null
                else notesState.notes[noteIndex]
            else -> null
        }

    val focusManager = LocalFocusManager.current

    var titleText by remember {
        mutableStateOf(note?.title ?: "")
    }

    var noteDescriptionText by remember {
        mutableStateOf(note?.description ?: "")
    }

    fun onBack() {
        focusManager.clearFocus()
        if (titleText != note?.title || noteDescriptionText != note.description) {
            if (titleText.isNotEmpty() || noteDescriptionText.isNotEmpty()) {
                if (note != null) {
                    homeViewModel.updateNote(
                        note.copy(
                            title = titleText,
                            description = noteDescriptionText,
                            lastEditedAt = LocalDate.now().toString(),
                        )
                    )
                } else {
                    homeViewModel.insertNote(
                        Note(
                            id = null,
                            title = titleText,
                            description = noteDescriptionText,
                            createdAt = LocalDate.now().toString(),
                            lastEditedAt = LocalDate.now().toString(),
                            noteTag = NoteTag.Ideas,
                        )
                    )
                }
            }
        }
        navController.popBackStack()
    }

    BackHandler(
        enabled = true,
        onBack = { onBack() }
    )

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
//                    if (navController.previousBackStackEntry != null)
                    NotzIconButton(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back Button",
                        onClick = {
                            onBack()
                        },
                    )
                },
                title = {},
                actions = {
                    if (note != null)
                        NotzIconButton(
                            Icons.Filled.Delete,
                            contentDescription = "Delete Button",
                            onClick = {
                                homeViewModel.deleteNote(note)
                                navController.popBackStack()
                            },
                        )
                }
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier.padding(paddingValues)
            ) {
                Column {
                    TextField(
                        value = titleText,
                        onValueChange = { titleText = it },
                        keyboardActions = KeyboardActions(
                            onNext = {
                                focusManager.moveFocus(FocusDirection.Next)
                            }
                        ),
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next
                        ),
                        placeholder = {
                            Text(
                                "Title", fontSize = 18.sp,
                            )
                        },
                        textStyle = TextStyle(
                            fontSize = 18.sp,
                        ),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                    TextField(
                        value = noteDescriptionText,
                        onValueChange = { noteDescriptionText = it },
                        keyboardActions = KeyboardActions(
                            onAny = {
                                focusManager.clearFocus()
                            }
                        ),
                        placeholder = { Text("Note") },
                        textStyle = TextStyle(
                            fontSize = 16.sp,
                        ),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            }
        }
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun NoteAddEditScreenPreview() {
    NoteAddEditScreen(
        navController = rememberNavController(),
        homeViewModel = hiltViewModel(),
        noteIndex = null,
    )
}