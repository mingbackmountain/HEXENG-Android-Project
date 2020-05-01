package com.example.hexeng.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.hexeng.R
import com.google.firebase.auth.FirebaseAuth

class SplashScreenActivity:AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        auth = FirebaseAuth.getInstance()
    }

    override fun onStart() {
        super.onStart()
        Handler().postDelayed({
            val currentUser = auth.currentUser
            if (currentUser == null) {
                startLoginActivity()
            } else {
                startProfileActivity()
            }
        },1500)
    }

    override fun onDestroy() {
        super.onDestroy()

        auth.signOut()
    }

    private fun startLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)

        startActivity(intent)
        finish()
    }

    private fun startProfileActivity() {
        val intent = Intent(this, ProfileActivity::class.java)

        startActivity(intent)
        finish()
    }
}



