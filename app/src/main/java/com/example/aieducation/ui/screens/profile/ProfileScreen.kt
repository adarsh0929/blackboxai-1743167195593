package com.example.aieducation.ui.screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aieducation.ui.components.FormTextField
import com.example.aieducation.ui.components.ProgressIndicator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Student Profile") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Filled.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // Progress Bar Section
            Text(
                text = "Learning Progress",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            ProgressIndicator(
                progress = 0.75f,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            )

            // Profile Information Section
            Text(
                text = "Personal Information",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            FormTextField(
                value = "John Doe",
                onValueChange = {},
                label = "Full Name",
                placeholder = "Enter your full name",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            FormTextField(
                value = "+1234567890",
                onValueChange = {},
                label = "WhatsApp Number",
                placeholder = "Enter your WhatsApp number",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            FormTextField(
                value = "john.doe@example.com",
                onValueChange = {},
                label = "Email ID",
                placeholder = "Enter your email address",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            FormTextField(
                value = "10th Standard",
                onValueChange = {},
                label = "Class",
                placeholder = "Enter your class/grade",
                modifier = Modifier.fillMaxWidth()
            )

            // Save Button
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = { /* Save profile */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text("Save Profile")
            }
        }
    }
}