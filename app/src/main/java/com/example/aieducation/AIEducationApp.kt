package com.example.aieducation

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AIEducationApp : Application() {
    override fun onCreate() {
        super.onCreate()
        
        // Initialize Firebase
        FirebaseApp.initializeApp(this)
        
        // Initialize Firebase services
        Firebase.auth
        Firebase.firestore
        
        // Initialize other app-wide components
        initializePaymentGateway()
    }
    
    private fun initializePaymentGateway() {
        // Payment gateway initialization logic
        // This will be implemented when we add Razorpay/Stripe
    }
}