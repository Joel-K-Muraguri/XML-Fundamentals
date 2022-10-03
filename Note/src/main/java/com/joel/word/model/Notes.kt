package com.joel.word.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NotesTable")
data class Notes(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    val title : String,
    val description : String

)
