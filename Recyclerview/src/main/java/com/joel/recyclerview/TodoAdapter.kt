package com.joel.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(
    private val todo : List<Todo>
)  : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(textView : View) : RecyclerView.ViewHolder(textView) {
        val tvTextView : TextView = textView.findViewById(R.id.textView)
        val cbCheckBox : CheckBox = textView.findViewById(R.id.checkBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
       val view = LayoutInflater.from(parent.context,).inflate(R.layout.text_view_item, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {

        val itemsBinder = todo[position]

        holder.tvTextView.text = itemsBinder.title
        holder.cbCheckBox.isChecked  = itemsBinder.isChecked

    }

    override fun getItemCount(): Int {
        return todo.size
    }

}