package com.example.hexeng.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hexeng.R
import kotlinx.android.synthetic.main.recycleview_row.view.*

class Adapter(private val items : ArrayList<String>, val onClickListener:() -> Unit) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycleview_row,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            onClickListener()
        }

        holder.itemView.item.text = items[position]
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {

}