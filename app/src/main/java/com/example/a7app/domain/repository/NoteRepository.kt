package com.example.a7app.domain.repository

import com.example.a7app.domain.model.Note
import com.example.a7app.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun createNote(note: Note): Flow<Resource<Unit>>

    fun getAllNotes(): Flow<Resource<List<Note>>>

    fun editNote(note: Note): Flow<Resource<Unit>>

    fun deleteNote(note: Note): Flow<Resource<Unit>>

}