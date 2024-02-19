@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.notz.ui.screen.home.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.notz.ui.componenets.NotzIconButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "notZ",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        },
        actions = {
            NotzIconButton(
                Icons.Default.Search,
                onClick = { /*TODO*/  },
                contentDescription = "Search",
            )
            NotzIconButton(
                Icons.Default.Settings,
                onClick = { /*TODO*/  },
                contentDescription = "Settings",
            )
        }
//        colors = topAppBarColors(
//            containerColor = MaterialTheme.colorScheme.primaryContainer,
//            titleContentColor = MaterialTheme.colorScheme.primary,
//        ),
    )
}

@Preview
@Composable
fun HomeScreenAppBarPreview() {
    HomeScreenAppBar()
}
