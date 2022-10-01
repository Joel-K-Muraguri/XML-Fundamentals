package com.joel.room.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class WordDatabase : RoomDatabase() {

    abstract fun getAllWordsDao() : WordDao

    companion object{
        @Volatile
        private var INSTANCE : WordDatabase ? = null

        fun getInstance(context: Context) : WordDatabase {
            return  INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordDatabase::class.java,
                    "Word_Database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}