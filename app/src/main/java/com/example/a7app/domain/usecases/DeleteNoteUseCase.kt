package com.example.a7app.domain.usecases

import com.example.a7app.domain.model.Note
import com.example.a7app.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    fun deleteNote(note: Note) = noteRepository.deleteNote(note)
}