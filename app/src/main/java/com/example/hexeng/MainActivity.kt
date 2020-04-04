package com.example.hexeng

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    // Initializing an empty ArrayList to be filled with animals
    val categoriesData: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Loads animals into the ArrayList
        addCategory()

        // Creates a vertical Layout Manager
        item_list.layoutManager = LinearLayoutManager(this)

        // You can use GridLayoutManager if you want multiple columns. Enter the number of columns as a parameter.
//        rv_animal_list.layoutManager = GridLayoutManager(this, 2)

        // Access the RecyclerView Adapter and load the data into it
        item_list.adapter = Adapter(categoriesData, this)

    }

    // Adds animals to the empty animals ArrayList
    fun addCategory() {
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