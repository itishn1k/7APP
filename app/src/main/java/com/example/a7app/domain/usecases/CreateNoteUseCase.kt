package com.example.a7app.domain.usecases

import com.example.a7app.domain.model.Note
import com.example.a7app.domain.repository.NoteRepository

class CreateNoteUseCase(private val noteRepository: NoteRepository) {

   fun createNote(note: Note) = noteRepository.createNote(note)
}

class EditNoteUseCase(private val noteRepository: NoteRepository) {

    fun editNote(note: Note) = noteRepository.editNote(note)
}

class DeleteNoteUseCase(private val noteRepository: NoteRepository) {

    fun deleteNote(note: Note) = noteRepository.deleteNote(note)
}

class GetAllNotesUseCase(private val noteRepository: NoteRepository) {

    fun getAllNotes(note: Note) = noteRepository.getAllNotes()
}