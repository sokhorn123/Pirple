package com.learn.projectbootcamday1

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.RecyclerView
import com.learn.projectbootcamday1.model.TodoItem

class ItemTodoListAdapter(private val totoList: ArrayList<TodoItem>) : RecyclerView.Adapter<ItemTodoListAdapter.MyViewHolder>() {

    class MyViewHolder(val linearLayout: LinearLayoutCompat) : RecyclerView.ViewHolder(linearLayout) // class use to bind our view (with our custom layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val linearLayout = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false) // inflate customView ( cast view to LinearLayout)
        linearLayout.setOnClickListener {
            // click an item to start a new action
        }
        return MyViewHolder(linearLayout as LinearLayoutCompat)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // to display data here
        val linearLayout = holder.linearLayout
        val tvTodoName = linearLayout.getChildAt(0) as TextView // this is will display textView at first
        val tvIsUrgents = linearLayout.getChildAt(1) as TextView
        val currentPosition = totoList[position]
        tvTodoName.text = currentPosition.name
        tvIsUrgents.text = if (currentPosition.isUrgent) "!!" else ""
    }

    override fun getItemCount(): Int {
        return totoList.size
    }
}
