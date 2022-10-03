package com.joel.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ItemTable")
data class Item(

    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val value : String,
)