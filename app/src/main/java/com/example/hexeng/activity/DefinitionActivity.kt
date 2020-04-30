package com.example.hexeng.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hexeng.R
import kotlinx.android.synthetic.main.definition_activity.*

class DefinitionActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.definition_activity)

        val extras = intent.extras
        val word: String? = extras?.getString("word")
        val meaning: String? = extras?.getString("meaning")

        word_text.text = word
        description_text.text = meaning
    }
}




