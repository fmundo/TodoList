package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import com.example.todolist.Model.EventItem

import io.realm.Realm

class AddToDoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_do)
        title = "New ToDo"
        val btn = findViewById<Button>(R.id.addToDoBtn)
        btn.setOnClickListener {
            val editText = findViewById<EditText>(R.id.todoEditTxr)
            val isImportant = findViewById<CheckBox>(R.id.importantEditCheckBox)
            val todo = EventItem()
            todo.name = editText.text.toString()
            todo.important = isImportant.isChecked
            val realm = Realm.getDefaultInstance()
            realm.beginTransaction()
            realm.copyToRealm(todo)
            realm.commitTransaction()
            finish()
        }
    }
}