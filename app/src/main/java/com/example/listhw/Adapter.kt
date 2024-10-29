package com.example.listhw

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.LinkedList
import java.util.Queue

class Adapter() : RecyclerView.Adapter<ViewHolder>() {

    private var items = ArrayList<Int>()

    private var queue: Queue<Int> = LinkedList()

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
        holder.itemView.setOnClickListener {
            deleteElem(position)
        }
    }

    fun setItems(list: List<Int>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    fun addItems(item: Int) {
        if (queue.isEmpty()) {
            items.add(item)
        } else {
            val idx = queue.remove()
            items.add(idx - 1, idx)
        }
        notifyDataSetChanged()
    }

    fun deleteElem(index: Int) {
        queue.add(items[index])
        items.removeAt(index)
        notifyDataSetChanged()
    }

    fun getItems(): List<Int> {
        return items
    }

    fun getQueue(): List<Int> {
        return queue.toList()
    }

    fun setQueue(newQueue: Queue<Int>) {
        queue = newQueue
    }
}
