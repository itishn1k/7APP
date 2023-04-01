package com.example.a7app.domain.repository

import com.example.a7app.domain.model.Note

interface NoteRepository {

    fun createNote(note: Note)

    fun getAllNotes(): List<Note>

    fun editNote(note: Note)

    fun deleteNote(note: Note)

}