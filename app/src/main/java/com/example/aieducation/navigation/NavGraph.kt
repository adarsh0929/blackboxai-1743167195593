package com.example.aieducation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.aieducation.ui.screens.auth.LoginScreen
import com.example.aieducation.ui.screens.auth.SignupScreen
import com.example.aieducation.ui.screens.chat.ChatScreen
import com.example.aieducation.ui.screens.payment.PaymentScreen
import com.example.aieducation.ui.screens.profile.ProfileScreen
import com.example.aieducation.ui.screens.quiz.QuizScreen
import com.example.aieducation.ui.screens.shop.ShopScreen
import com.example.aieducation.ui.screens.subscription.SubscriptionScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Auth.route
    ) {
        // Auth Screens
        composable(Screen.Auth.route) { 
            LoginScreen(
                onLoginSuccess = { navController.navigate(Screen.Chat.route) },
                onSignupClick = { navController.navigate(Screen.Signup.route) }
            )
        }
        composable(Screen.Signup.route) {
            SignupScreen(
                onSignupSuccess = { navController.navigate(Screen.Chat.route) },
                onBackClick = { navController.popBackStack() }
            )
        }

        // Main Screens
        composable(Screen.Chat.route) { 
            ChatScreen(
                onProfileClick = { navController.navigate(Screen.Profile.route) },
                onShopClick = { navController.navigate(Screen.Shop.route) },
                onQuizClick = { navController.navigate(Screen.Quiz.route) }
            )
        }
        composable(Screen.Profile.route) { 
            ProfileScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
        composable(Screen.Shop.route) { 
            ShopScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
        composable(Screen.Quiz.route) { 
            QuizScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
        composable(Screen.Payment.route) { 
            PaymentScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
        composable(Screen.Subscription.route) { 
            SubscriptionScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}

sealed class Screen(val route: String) {
    object Auth : Screen("auth")
    object Signup : Screen("signup")
    object Chat : Screen("chat")
    object Profile : Screen("profile")
    object Shop : Screen("shop")
    object Quiz : Screen("quiz")
    object Payment : Screen("payment")
    object Subscription : Screen("subscription")
}