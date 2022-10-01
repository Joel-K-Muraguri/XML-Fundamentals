package com.joel.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "WordTable")
data class Word(
    @PrimaryKey(autoGenerate = true)
    val id : Int,

    val Title : String,
    val word : String
)
