package com.example.hexeng.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hexeng.R
import com.example.hexeng.adapter.VocabAdapter
import com.example.hexeng.model.Vocab
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import kotlinx.android.synthetic.main.vocab_list_activity.*


class VocabListActivity : AppCompatActivity() {

    private var mAdapter = VocabAdapter()
    private var firestoreDB : FirebaseFirestore? = null
    private var firestoreListener: ListenerRegistration? = null
    private var listVocab = ArrayList<Vocab>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vocab_list_activity)

        item_list.layoutManager = LinearLayoutManager(this)
        item_list.adapter = mAdapter

        val extras = intent.extras
        val catID: String? = extras?.getString("catID")
        val catName: String? = extras?.getString("catName")

        vocab_title.text = catName

        firestoreDB = FirebaseFirestore.getInstance()

        firestoreListener =
            firestoreDB!!.collection("Category/$catID/words")
                .addSnapshotListener(EventListener{ snapshots, e ->
                    if(e != null) {
                        Log.w("thisis", "error",e)
                    }

                    if(snapshots != null) {
                        for(vocab in snapshots.documents) {
                            val vocabInfo = vocab.data
                            val id = vocab.id
                            if (vocabInfo != null) {
                                this.addVocab(id, vocabInfo)
                            }
                        }
                        mAdapter.update(listVocab)
                    }
                })
        setupButton()
    }

    override fun onDestroy() {
        super.onDestroy()
        firestoreListener!!.remove()
    }

    private fun addVocab(id:String,vocabInfo:MutableMap<String,Any>) {
        listVocab.add(
            Vocab(
                id,
                vocabInfo["word"] as String,
                vocabInfo["meaning"] as String
            )
        )
    }

    private fun setupButton() {
        val extras = Bundle()
        extras.putParcelableArrayList("vocabList",listVocab)

        btn_start_vocab!!.setOnClickListener { startActivity(
            Intent(this, GameActivity::class.java).putExtras(extras))
            finish()
        }
    }

}




