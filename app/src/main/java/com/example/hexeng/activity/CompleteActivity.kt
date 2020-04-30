package com.example.hexeng.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.hexeng.ProfileActivity
import com.example.hexeng.R
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.complete_activity.*

class CompleteActivity: AppCompatActivity() {
    private var db = Firebase.firestore
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.complete_activity)

       val score = intent.extras?.getInt("total-score")

        total_score.text = score.toString()

        setupButton()

        auth = FirebaseAuth.getInstance()

        var user = auth.currentUser


        db.collection("Users").whereEqualTo("uid",user?.uid)
            .get().addOnSuccessListener { documents ->
               for(document in documents) {
                   var totalScore = document.data["score"].toString().toInt() + score!!

                   db.collection("Users").document(document.id).update(
                       "score",totalScore.toString()
                   )
               }
            }
    }

    private fun setupButton() {
        var intent = Intent(this,ProfileActivity::class.java)
       back_to_profile!!.setOnClickListener { startActivity(intent) }
    }
}
