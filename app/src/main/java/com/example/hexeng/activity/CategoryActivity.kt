package com.example.hexeng.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hexeng.Adapter
import com.example.hexeng.R
import kotlinx.android.synthetic.main.category_activity.*


class CategoryActivity : AppCompatActivity() {

    private val categoriesData: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category_activity)

        addCategory()

        setupView()

    }

    private fun setupView() {
        item_list.layoutManager = LinearLayoutManager(this)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        item_list.adapter = Adapter(
            categoriesData
        ) { startVocabListActivity() }
    }

    private fun startVocabListActivity() {
        val intent = Intent(this, VocabListActvity::class.java)
        startActivity(intent)
    }

    private fun addCategory() {
        categoriesData.add("argument and language")
        categoriesData.add("emotions")
        categoriesData.add("energy")
        categoriesData.add("friends and enemies")
        categoriesData.add("give up")
        categoriesData.add("knowledge and skill")
        categoriesData.add("law and order")
        categoriesData.add("money")
        categoriesData.add("politics and tradition")
        categoriesData.add("praise and criticism")
        categoriesData.add("pride")
        categoriesData.add("tiger")
        categoriesData.add("science")
        categoriesData.add("size, amount, location")
        categoriesData.add("the senses")
        categoriesData.add("time")
        categoriesData.add("truth")
        categoriesData.add("elephant")
        categoriesData.add("war and peace")
    }
}