package com.learn.projectbootcamday1.model

import java.util.*

class TodoItem(var name: String) {
    var isUrgent = false // set default value to false
    var date = Calendar.getInstance()

    constructor(name: String, isUrgent: Boolean) : this(name) {
        this.isUrgent = isUrgent
    }

    fun getDateString(): String {
        val year = date.get(Calendar.YEAR).toString()
        val month = date.get(Calendar.MONTH).toString()
        val day = date.get(Calendar.DATE).toString()

        return "$year/$month/$day"
    }
}
