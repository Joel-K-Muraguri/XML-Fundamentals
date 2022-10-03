package com.joel.word.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application) : AndroidViewModel(application) {

    val allNotes : LiveData<List<Notes>>
    private val repository : NotesRepository


    init {
        val dao = NotesDatabase.getInstance(application).getAllNotes()
        repository = NotesRepository(dao)
        allNotes = repository.allNotes
    }

    fun insert(notes: Notes) {
        viewModelScope.launch { Dispatchers.IO
            repository.insert(notes)

        }
    }

    fun update(notes: Notes) {
        viewModelScope.launch { Dispatchers.IO
            repository.update(notes)

        }
    }

    fun delete(notes: Notes) {
        viewModelScope.launch { Dispatchers.IO
            repository.delete(notes)
        }
    }


}