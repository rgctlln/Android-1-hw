package com.example.listhw

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.LinkedList

class Activity : AppCompatActivity() {

    companion object {
        //        const val ITEMS_CNT = "ITEMS_CNT"
        const val QUEUE = "QUEUE"
        const val ITEMS_LEFT = "ITEMS_LEFT"
    }

    lateinit var recyclerView: RecyclerView
    lateinit var fab: FloatingActionButton

    private val adapter = Adapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)
        fab = findViewById(R.id.fab)
        recyclerView.adapter = adapter
        fab.setOnClickListener {
            adapter.addItems(adapter.itemCount + 1)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntegerArrayList(ITEMS_LEFT, ArrayList(adapter.getItems()))
        outState.putIntegerArrayList(QUEUE, ArrayList(adapter.getQueue()))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val itemsList = savedInstanceState.getIntegerArrayList(ITEMS_LEFT)
        if (itemsList != null) {
            adapter.setItems(itemsList)
        }
        val queueList = savedInstanceState.getIntegerArrayList(QUEUE)
        if (queueList != null) {
            adapter.setQueue(LinkedList(queueList))
        }
    }
}