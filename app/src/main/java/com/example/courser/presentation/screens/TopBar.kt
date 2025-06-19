package com.example.courser.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Functions
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.courser.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(16.dp).padding(top = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Search courses...") },
            leadingIcon = { Icon(Icons.Default.Search, null, tint = Color.White) },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFF1E1E1E),

            ),
            modifier = Modifier.clip(RoundedCornerShape(26.dp)).weight(1f).height(56.dp),
        )
        Spacer(Modifier.width(8.dp))

        Box(
            modifier = Modifier
                .size(56.dp)
                .background(Color(0xFF1E1E1E), CircleShape)
                .clip(CircleShape)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.funnel),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.Center) )
        }
    }
}