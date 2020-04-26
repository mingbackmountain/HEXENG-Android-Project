package com.example.hexeng.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hexeng.adapter.Adapter
import com.example.hexeng.R
import kotlinx.android.synthetic.main.vocab_list_activity.*


class VocabListActivity : AppCompatActivity() {


    private val vocabData: ArrayList<String> = ArrayList()
    private var btnStart: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vocab_list_activity)


        addVocab()

        setupView()
    }

    private fun setupView() {
        item_list.layoutManager = LinearLayoutManager(this)
        setupRecyclerView()
        setupButton()
    }

    private fun setupRecyclerView() {
        item_list.adapter = Adapter(
            vocabData
        ) { startDefinitionActivity() }
    }

    private fun startDefinitionActivity() {
        val intent = Intent(this,DefinitionActivity::class.java)
        startActivity(intent)
    }

    private fun setupButton() {
        btnStart = findViewById<View>(R.id.btn_start_vocab) as Button

        btnStart!!.setOnClickListener { startActivity(
            Intent(this,
                GameActivity::class.java)
        ) }
    }


    private fun addVocab() {
        vocabData.add("abstract")
        vocabData.add("affirmation")
        vocabData.add("analogous")
        vocabData.add("anecdote")
        vocabData.add("antithesis")
        vocabData.add("articulation")
        vocabData.add("assert")
        vocabData.add("bias")
        vocabData.add("blatant")
        vocabData.add("brevity")
        vocabData.add("cliché")
        vocabData.add("compelling")
        vocabData.add("comprehensive")
        vocabData.add("concise")
        vocabData.add("conjecture")
        vocabData.add("consensus")
    }
}