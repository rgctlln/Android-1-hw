package com.example.listhw

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Activity : AppCompatActivity() {

    companion object {
        const val ITEMS_CNT = "ITEMS_CNT"
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
        outState.putInt(ITEMS_CNT, adapter.itemCount)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val prevStateSize: Int = savedInstanceState.getInt(ITEMS_CNT)
        for (i in 1..prevStateSize) {
            adapter.addItems(i)
        }
    }
}