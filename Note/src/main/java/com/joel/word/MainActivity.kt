package com.joel.word

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.joel.word.model.Notes
import com.joel.word.model.NotesViewModel

class MainActivity : AppCompatActivity(), OnDeleteClick, OnNoteClick {

    lateinit var notesRV : RecyclerView
    lateinit var fbAction : FloatingActionButton
    lateinit var viewModel : NotesViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_notes)

        notesRV = findViewById(R.id.recyclerView)
        fbAction = findViewById(R.id.floatingActionButton)
        notesRV.layoutManager = LinearLayoutManager(this)

        val notesAdapter = NotesAdapter(this, this, this)

        notesRV.adapter = notesAdapter
        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application))[NotesViewModel::class.java]
        viewModel.allNotes.observe(this, Observer{ list ->
            list?.let {

            }
        })
        fbAction.setOnClickListener {
            val intent = Intent(this@MainActivity, AddEditActivity::class.java)
            startActivity(intent)
            this.finish()

        }
    }

    override fun onDeleteClick(notes: Notes) {
        viewModel.delete(notes)
        Toast.makeText(this, "${notes.title} Deleted", Toast.LENGTH_SHORT).show()
    }

    override fun onNoteClick(notes: Notes) {
       val intent = Intent(this@MainActivity, AddEditActivity::class.java)
        intent.putExtra("NotesType", "Edit")
        intent.putExtra("NotesTitle", notes.title)
        intent.putExtra("NotesDescription", notes.description)
        intent.putExtra("NotesID", notes.id)
        startActivity(intent)
        this.finish()
    }


}