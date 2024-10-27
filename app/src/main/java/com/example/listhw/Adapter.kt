package com.example.listhw

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter() : RecyclerView.Adapter<ViewHolder>() {

    private val items = ArrayList<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
        holder.color(items[position] % 2 != 0)
    }

    fun setItems(list: List<Int>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
        //DiffUtils
    }

    fun addItems(item: Int) {
        items.add(item)
        notifyDataSetChanged()
    }
}