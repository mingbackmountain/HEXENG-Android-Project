package com.example.hexeng.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hexeng.adapter.Adapter
import com.example.hexeng.R
import com.example.hexeng.adapter.CategoryAdapter
import com.example.hexeng.model.Category
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import kotlinx.android.synthetic.main.category_activity.*


class CategoryActivity : AppCompatActivity() {

    private val TAG = "CategoryActivity"
    private var mAdapter:CategoryAdapter? = null
    private var firestoreDB : FirebaseFirestore? = null
    private var firestoreListener: ListenerRegistration? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category_activity)

        firestoreDB = FirebaseFirestore.getInstance()

        firestoreListener = firestoreDB!!.collection("Category")
                            .addSnapshotListener(EventListener{documentSnapshots, e ->
                                if(e != null) {
                                    Log.e(TAG,"listen failed!",e)
                                }

                                val categoryList = mutableListOf<Category>()

                                if (documentSnapshots != null) {
                                    for(doc in documentSnapshots) {
                                        val category = doc.toObject(Category::class.java)
                                        category.id = doc.id
                                        categoryList.add(category)
                                    }

                                    mAdapter = CategoryAdapter(categoryList) {
                                        startVocabListActivity()
                                    }
                                }
                            })
    }

    override fun onDestroy() {
        super.onDestroy()

        firestoreListener!!.remove()
    }



    private fun startVocabListActivity() {
        val intent = Intent(this, VocabListActivity::class.java)
        startActivity(intent)
    }
}