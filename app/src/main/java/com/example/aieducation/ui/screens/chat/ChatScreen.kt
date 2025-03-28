package com.example.aieducation.ui.screens.chat

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.aieducation.ui.theme.ChatPlaceholderTextStyle

@Composable
fun ChatScreen(
    onProfileClick: () -> Unit,
    onShopClick: () -> Unit,
    onQuizClick: () -> Unit
) {
    var message by remember { mutableStateOf("") }
    val messages = remember { mutableStateListOf<ChatMessage>() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("AI Education Chat") },
                actions = {
                    IconButton(onClick = { /* Toggle theme */ }) {
                        Icon(Icons.Filled.Brightness4, "Toggle theme")
                    }
                    IconButton(onClick = onProfileClick) {
                        Icon(Icons.Filled.Person, "Profile")
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    IconButton(onClick = onShopClick) {
                        Icon(Icons.Filled.ShoppingCart, "Shop")
                    }
                    IconButton(onClick = onQuizClick) {
                        Icon(Icons.Filled.Quiz, "Quiz")
                    }
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // Chat messages
            LazyColumn(
                modifier = Modifier.weight(1f),
                reverseLayout = true
            ) {
                items(messages.reversed()) { message ->
                    ChatBubble(message = message)
                }
            }

            // Message input
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = message,
                    onValueChange = { message = it },
                    placeholder = {
                        Text(
                            "How may I assist you today?",
                            style = ChatPlaceholderTextStyle
                        )
                    },
                    modifier = Modifier.weight(1f)
                )
                IconButton(
                    onClick = {
                        if (message.isNotBlank()) {
                            messages.add(ChatMessage(message, true))
                            message = ""
                        }
                    }
                ) {
                    Icon(Icons.Filled.Send, "Send")
                }
            }
        }
    }
}

data class ChatMessage(
    val text: String,
    val isUser: Boolean
)

@Composable
fun ChatBubble(message: ChatMessage) {
    val bubbleColor = if (message.isUser) {
        MaterialTheme.colorScheme.primaryContainer
    } else {
        MaterialTheme.colorScheme.secondaryContainer
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        contentAlignment = if (message.isUser) Alignment.CenterEnd else Alignment.CenterStart
    ) {
        Card(
            colors = CardDefaults.cardColors(containerColor = bubbleColor)
        ) {
            Text(
                text = message.text,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}