package com.example.to_dolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var todoadapter:TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoadapter= TodoAdapter(mutableListOf())

        rvTodoItems.adapter=todoadapter

        rvTodoItems.layoutManager=LinearLayoutManager(this)

        btTodoAdd.setOnClickListener {
            val todoTitle=etTodoTitle.text.toString()
            if (todoTitle.isNotEmpty()){
                val todo=Todo(todoTitle)
                todoadapter.addTodo(todo)
                etTodoTitle.text.clear()
            }
        }
        btTodoRemove.setOnClickListener { todoadapter.deleteDoneTodos() }
    }

}