package com.joel.room.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val repository : WordRepository
    private val allWords : LiveData<List<Word>>

    init {
        val dao = WordDatabase.getInstance(application).getAllWordsDao()
        repository = WordRepository(dao)
        allWords = repository.allNotes
    }



}