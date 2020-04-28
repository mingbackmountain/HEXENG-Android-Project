package com.example.hexeng

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.hexeng.activity.CategoryActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.profile_activity.*
import kotlin.math.log

class ProfileActivity : AppCompatActivity() {

    private var btnStart: Button? = null
    private var nameText: TextView? = null
    private var mAuth: FirebaseAuth? = null
    private var db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_activity)

        initialise()
    }

    private fun initialise() {

        nameText = findViewById<View>(R.id.nameTextView) as TextView
        btnStart = findViewById<View>(R.id.btn_start) as Button
        val user = FirebaseAuth.getInstance().currentUser

        if (user != null) {
            db.collection("Users").whereEqualTo("uid",user.uid).get().addOnSuccessListener {users ->
                for( user in users) {
                    nameTextView.text = user.data["firstname"].toString()
                    text_score.text = user.data["score"].toString()
                }
            }
        }


        btnStart!!.setOnClickListener { startActivity(
                Intent(this@ProfileActivity,
                    CategoryActivity::class.java)
            )
            finish()

        }
    }
}