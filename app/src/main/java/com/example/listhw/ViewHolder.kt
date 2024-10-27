package com.example.listhw

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val text = view.findViewById<TextView>(R.id.text_1)
    val image = view.findViewById<ImageView>(R.id.image_view)

    fun bind(number: Int) {
        text.text = "$number"
    }

    fun color(isOdd: Boolean) {
        if (isOdd) {
            image.setBackgroundResource(R.color.blue)
        } else {
            image.setBackgroundResource(R.color.red)
        }
    }
}