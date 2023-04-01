package com.example.a7app.data.local.mapper

import com.example.a7app.data.model.NoteEntity
import com.example.a7app.domain.model.Note

fun Note.toNoteEntity() = NoteEntity(id, title, description)

fun NoteEntity.toNote() = Note(id, title, description)