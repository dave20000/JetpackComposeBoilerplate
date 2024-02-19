@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.notz.ui.screen.note_detail.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notz.ui.componenets.NotzIconButton

@Composable
fun NoteDetailAppBar(
    noteTitle: String,
    appBarScrollBehavior: TopAppBarScrollBehavior,
    navController: NavHostController,
) {
    MediumTopAppBar(
        scrollBehavior = appBarScrollBehavior,
        title = {
            Text(
                noteTitle,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            if (navController.previousBackStackEntry != null)
                NotzIconButton(
                    Icons.Filled.ArrowBack,
                    contentDescription = "Back Button",
                    onClick = {
                        navController.popBackStack()
                    },
                )
        },
        actions = {
            NotzIconButton(
                Icons.Filled.Edit,
                contentDescription = "Back Button",
                onClick = { /* do something */ },
            )
            NotzIconButton(
                Icons.Filled.Delete,
                contentDescription = "Back Button",
                onClick = { /* do something */ },
            )
        },
        //        colors = TopAppBarDefaults.topAppBarColors(
//            containerColor = MaterialTheme.colorScheme.primaryContainer,
//            titleContentColor = MaterialTheme.colorScheme.primary,
//        ),
    )
}

@Preview
@Composable
fun NoteDetailAppBarPreview() {
    NoteDetailAppBar(
        noteTitle = "New Note",
        appBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState()),
        navController = rememberNavController()
    )
}