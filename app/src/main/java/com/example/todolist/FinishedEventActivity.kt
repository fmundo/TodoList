package com.example.todolist

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todolist.Model.EventItem
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_finished_event.*

class FinishedEventActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Complete ToDo"
        setContentView(R.layout.activity_finished_event)
        val todoId = intent.getStringExtra(TODO_EVENT)
        val realm = Realm.getDefaultInstance()
        val todoItem = realm.where(EventItem::class.java)
            .equalTo("id", todoId)
            .findFirst()
        if (todoItem != null) {
            todoNameTxt.text = todoItem?.name
            if (todoItem.important) {
                todoNameTxt.setTypeface(Typeface.DEFAULT_BOLD)
            }
            completeBtn.setOnClickListener {
                if (todoItem != null) {
                    realm.beginTransaction()
                    todoItem.deleteFromRealm()
                    realm.commitTransaction()
                    finish()
                }
            }
        }


    }
}