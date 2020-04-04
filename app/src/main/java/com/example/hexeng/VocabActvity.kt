package com.example.hexeng

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class VocabActvity : AppCompatActivity() {

    // Initializing an empty ArrayList to be filled with animals
    val vocabData: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vocab)

        // Loads animals into the ArrayList
        addVocab()

        // Creates a vertical Layout Manager
        item_list.layoutManager = LinearLayoutManager(this)

        // You can use GridLayoutManager if you want multiple columns. Enter the number of columns as a parameter.
//        rv_animal_list.layoutManager = GridLayoutManager(this, 2)

        // Access the RecyclerView Adapter and load the data into it
        item_list.adapter = Adapter(vocabData, this)

    }

    // Adds animals to the empty animals ArrayList
    fun addVocab() {
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