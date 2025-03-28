package com.example.aieducation.ui.screens.shop

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aieducation.ui.components.ShopItemCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopScreen(
    onBackClick: () -> Unit
) {
    val shopItems = listOf(
        ShopItem("Mathematics Textbook", "Class 10", 499),
        ShopItem("Science Notes", "Complete syllabus", 299),
        ShopItem("History Course", "Video lessons", 999),
        ShopItem("English Grammar", "Workbook", 199),
        ShopItem("Physics Formulas", "Quick reference", 149)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Education Shop") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Filled.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(shopItems) { item ->
                ShopItemCard(
                    item = item,
                    onPurchaseClick = { /* Handle purchase */ }
                )
            }
        }
    }
}

data class ShopItem(
    val title: String,
    val description: String,
    val price: Int
)