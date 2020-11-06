package com.learn.projectbootcamday1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learn.projectbootcamday1.model.TodoItem

class HomePage : AppCompatActivity() {
    private lateinit var itemRecyclerView: RecyclerView
    private lateinit var itemTodoListAdapter: ItemTodoListAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    var todoList = ArrayList<TodoItem>()
    private lateinit var btnAdd: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        // pass your data here
        todoList.add(TodoItem("Go to school"))
        todoList.add(TodoItem("Prepare for lunch", true))
        todoList.add(TodoItem("Do Homework", false))
        todoList.add(TodoItem("Group Meeting", true))

        itemRecyclerView = findViewById(R.id.rcyTodoItem)
        linearLayoutManager = LinearLayoutManager(this)
        itemTodoListAdapter = ItemTodoListAdapter(todoList)

        itemRecyclerView.apply {
            adapter = itemTodoListAdapter
            layoutManager = linearLayoutManager
            setHasFixedSize(true)
        }
        btnAdd = findViewById(R.id.btnAdd)
    }

    fun addNew(view: View) {
        val intent: Intent = Intent(this, SecondScreen::class.java)
        intent.putExtra("This is a String from activity a", "strA2b")
        startActivity(intent) // this is will start new activity
    }
}
