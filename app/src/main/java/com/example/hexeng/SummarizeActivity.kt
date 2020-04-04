package com.example.hexeng

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SummarizeActivity : AppCompatActivity() {

    private var btnStart: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smmarize)

        initialise()
    }

    private fun initialise() {

        btnStart = findViewById<View>(R.id.btn_start) as Button

        btnStart!!.setOnClickListener { startActivity(
                Intent(this@SummarizeActivity,
                    MainActivity::class.java)
            ) }
    }
}