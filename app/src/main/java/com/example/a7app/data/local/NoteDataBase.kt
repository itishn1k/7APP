package com.example.a7app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.a7app.data.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDataBase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

}