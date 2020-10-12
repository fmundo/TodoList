package com.example.todolist.Model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class EventItem : RealmObject() {
    @PrimaryKey
    private var id = UUID.randomUUID().toString()
    var name = ""
    var important = false
    fun getId() : String {
        return id
    }
    override fun toString(): String {
        return name
    }

}