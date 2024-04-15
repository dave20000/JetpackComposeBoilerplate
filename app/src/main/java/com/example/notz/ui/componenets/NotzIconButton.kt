package com.example.notz.ui.componenets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun NotzIconButton(
    imageVector: ImageVector,
    onClick: () -> Unit,
    contentDescription : String,
) {
    OutlinedIconButton(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.secondary)
    ) {
        Icon(
            imageVector,
            contentDescription = contentDescription,
            modifier = Modifier.size(24.dp)
        )
    }
}