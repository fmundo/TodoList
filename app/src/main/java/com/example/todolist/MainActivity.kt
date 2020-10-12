package com.example.todolist

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.todolist.Adapter.TodDoItemAdapter
import com.example.todolist.Model.EventItem
import io.realm.Realm

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            var addIntent = Intent(this, AddToDoActivity::class.java)
            startActivity(addIntent)
        }


    }

    override fun onResume() {
        super.onResume()
        // Load Item
        val realm = Realm.getDefaultInstance()
        val query = realm.where(EventItem::class.java)
        val results = query.findAll()
        val listView = findViewById<ListView>(R.id.todoListView)
        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = results[position]
            val finishIntent = Intent(this, FinishedEventActivity::class.java)
            finishIntent.putExtra(TODO_EVENT, selectedItem?.getId())
            startActivity(finishIntent)
        }
        val adapter = TodDoItemAdapter(this, android.R.layout.simple_list_item_1, results)
        listView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}