package com.example.aieducation.ui.screens.payment

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.aieducation.ui.components.FormTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(
    onBackClick: () -> Unit
) {
    var amount by remember { mutableStateOf("") }
    var isDeposit by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Payment") },
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
                .padding(16.dp)
        ) {
            // Toggle between deposit and withdraw
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                FilterChip(
                    selected = isDeposit,
                    onClick = { isDeposit = true },
                    label = { Text("Deposit") }
                )
                FilterChip(
                    selected = !isDeposit,
                    onClick = { isDeposit = false },
                    label = { Text("Withdraw") }
                )
            }
            Spacer(modifier = Modifier.height(24.dp))

            // Amount input
            FormTextField(
                value = amount,
                onValueChange = { amount = it },
                label = "Amount (₹)",
                placeholder = "Enter amount",
                keyboardType = KeyboardType.Number,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Current balance display
            Text(
                text = "Current Balance: ₹500",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Submit button
            Button(
                onClick = { /* Handle payment */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(if (isDeposit) "Deposit" else "Withdraw")
            }
        }
    }
}