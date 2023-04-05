package com.example.a7app.domain.usecases

import com.example.a7app.domain.model.Note
import com.example.a7app.domain.repository.NoteRepository
import javax.inject.Inject

class EditNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    fun editNote(note: Note) = noteRepository.editNote(note)
}