package com.joel.word.model

import androidx.lifecycle.LiveData

class NotesRepository(private val dao : NotesDao) {

    val allNotes : LiveData<List<Notes>> = dao.getAllWords()

    suspend fun insert(notes: Notes){
        dao.insert(notes)
    }

    suspend fun update(notes: Notes){
        dao.update(notes)
    }

    suspend fun delete(notes: Notes){
        dao.delete(notes)
    }




}