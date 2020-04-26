package com.example.hexeng.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hexeng.R
import com.example.hexeng.model.Category
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.recycleview_row.view.*


class CategoryAdapter(
    private val categoryList: MutableList<Category>,
    val onClickListener:() -> Unit
): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycleview_row,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.itemView?.setOnClickListener {
            onClickListener()
        }

        val category = categoryList[position]
        if (holder != null) {
            holder.itemView.item.text = category.name
        }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    inner class ViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
    }
}

