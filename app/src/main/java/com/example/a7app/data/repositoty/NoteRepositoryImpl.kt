package com.example.a7app.data.repositoty

import com.example.a7app.data.local.NoteDao
import com.example.a7app.data.local.mapper.toNote
import com.example.a7app.data.local.mapper.toNoteEntity
import com.example.a7app.domain.model.Note
import com.example.a7app.domain.repository.NoteRepository

class NoteRepositoryImpl(
    private val noteDao: NoteDao
) : NoteRepository {
    override fun createNote(note: Note) {
        noteDao.createNote(note.toNoteEntity())
    }

    override fun getAllNotes(): List<Note> {
        return noteDao.getAllNotes().map { it.toNote() }
    }

    override fun editNote(note: Note) {
        noteDao.editNote(note.toNoteEntity())
    }

    override fun deleteNote(note: Note) {
        noteDao.deleteNote(note.toNoteEntity())
    }
}