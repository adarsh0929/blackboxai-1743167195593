package com.example.aieducation.ui.screens.quiz

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizScreen(
    onBackClick: () -> Unit
) {
    var currentQuestionIndex by remember { mutableStateOf(0) }
    val questions = listOf(
        "What is the capital of France?",
        "What is 2 + 2?",
        "What is the largest planet in our solar system?",
        "What is the boiling point of water?",
        "What is the chemical symbol for gold?"
    )
    val totalQuestions = questions.size

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Quiz") },
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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (currentQuestionIndex < totalQuestions) {
                Text(
                    text = questions[currentQuestionIndex],
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                // Placeholder for answer options
                // In a real app, you would have buttons or radio buttons for answers
                Button(
                    onClick = {
                        currentQuestionIndex++
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Next Question")
                }
            } else {
                Text(
                    text = "Quiz Completed!",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Button(
                    onClick = { /* Handle quiz restart or navigation */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Restart Quiz")
                }
            }
        }
    }
}