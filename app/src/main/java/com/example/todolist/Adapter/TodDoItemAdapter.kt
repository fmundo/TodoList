package com.example.todolist.Adapter

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.todolist.Model.EventItem
import java.util.*

class TodDoItemAdapter(context: Context, resource: Int, objects: MutableList<EventItem>) : ArrayAdapter<EventItem>(context, resource, objects) {
    override fun getCount(): Int {
        return super.getCount()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflator = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val todoView = inflator.inflate(android.R.layout.simple_list_item_1, parent, false) as TextView
        val todoItem = getItem(position)
        if (todoItem != null) {
            todoView.text = todoItem.name
            if (todoItem.important) {
                todoView.setTypeface(Typeface.DEFAULT_BOLD)
            }
        }
        return todoView
    }
}