package com.joel.word

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.joel.word.model.Notes
import com.joel.word.model.NotesViewModel

class AddEditActivity : AppCompatActivity() {

    lateinit var edNoteTitle : EditText
    lateinit var edNoteDescription : EditText
    lateinit var btnSave : Button
    lateinit var viewModel: NotesViewModel
    var noteID = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit)
        edNoteTitle = findViewById(R.id.editTextTextTitle)
        edNoteDescription = findViewById(R.id.editTextTextDescription)
        btnSave = findViewById(R.id.save_button)
        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application))[NotesViewModel::class.java]


        val noteType = intent.getStringExtra("NotesType")
        if (noteType.equals("Edit")){
            val noteTitle = intent.getStringExtra("NotesTitle")
            val noteDescription =  intent.getStringExtra("NotesDescription")
            noteID = intent.getIntExtra("noteID", -1)
            btnSave.text = "Update Note"
            edNoteTitle.setText(noteTitle)
            edNoteDescription.setText(noteDescription)
        }
        else{
            btnSave.text = "Save Note"
        }

        btnSave.setOnClickListener {
            Log.d("SAVE ", noteID.toString())
            val noteTitle = edNoteTitle.text.toString()
            val noteDescription = edNoteDescription.text.toString()
            if (noteType.equals("Edit")){
                if (noteTitle.isNotEmpty() && noteDescription.isNotEmpty()){
                    val updateNote = Notes(
                        id =  noteID,
                        title = noteTitle,
                        description =  noteDescription
                    )
                    updateNote.id = noteID
                    viewModel.update(updateNote)
                    Toast.makeText(this, "Note Updated", Toast.LENGTH_SHORT).show()
                }
                else{
                    if (noteTitle.isNotEmpty() && noteDescription.isNotEmpty()){
                        viewModel.insert(Notes(noteID, noteTitle, noteDescription))
                        Toast.makeText(this, "Note Added", Toast.LENGTH_SHORT).show()
                    }
                }
                startActivity(Intent(applicationContext, MainActivity::class.java))
                this.finish()
            }
        }

    }
}