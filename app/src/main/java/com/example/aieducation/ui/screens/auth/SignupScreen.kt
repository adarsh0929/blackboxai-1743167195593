package com.example.aieducation.ui.screens.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.aieducation.ui.components.FormTextField
import com.example.aieducation.ui.theme.ChatPlaceholderTextStyle

@Composable
fun SignupScreen(
    onSignupSuccess: () -> Unit,
    onBackClick: () -> Unit
) {
    var fullName by remember { mutableStateOf("") }
    var whatsappNumber by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var studentClass by remember { mutableStateOf("") }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Create Account",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(32.dp))
            
            FormTextField(
                value = fullName,
                onValueChange = { fullName = it },
                label = "Full Name",
                placeholder = "Enter your full name"
            )
            Spacer(modifier = Modifier.height(16.dp))
            
            FormTextField(
                value = whatsappNumber,
                onValueChange = { whatsappNumber = it },
                label = "WhatsApp Number",
                placeholder = "Enter your WhatsApp number",
                keyboardType = KeyboardType.Phone
            )
            Spacer(modifier = Modifier.height(16.dp))
            
            FormTextField(
                value = email,
                onValueChange = { email = it },
                label = "Email ID",
                placeholder = "Enter your email address",
                keyboardType = KeyboardType.Email
            )
            Spacer(modifier = Modifier.height(16.dp))
            
            FormTextField(
                value = studentClass,
                onValueChange = { studentClass = it },
                label = "Class",
                placeholder = "Enter your class/grade"
            )
            Spacer(modifier = Modifier.height(32.dp))
            
            Button(
                onClick = onSignupSuccess,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sign Up")
            }
            Spacer(modifier = Modifier.height(16.dp))
            
            TextButton(onClick = onBackClick) {
                Text("Already have an account? Login")
            }
        }
    }
}