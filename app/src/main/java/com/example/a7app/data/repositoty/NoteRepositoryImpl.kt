package com.example.a7app.data.repositoty

import com.example.a7app.data.base.BaseRepository
import com.example.a7app.data.local.NoteDao
import com.example.a7app.data.local.mapper.toNote
import com.example.a7app.data.local.mapper.toNoteEntity
import com.example.a7app.domain.model.Note
import com.example.a7app.domain.repository.NoteRepository
import com.example.a7app.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
) : NoteRepository, BaseRepository() {

    override fun getAllNotes() = doRequest {
        noteDao.getAllNotes().map { it.toNote() }
    }

    override fun createNote(note: Note) = doRequest {
        noteDao.createNote(note.toNoteEntity())
    }

    override fun editNote(note: Note) = doRequest {
        noteDao.editNote(note.toNoteEntity())
    }

    override fun deleteNote(note: Note) = doRequest {
        noteDao.deleteNote(note.toNoteEntity())
    }
}