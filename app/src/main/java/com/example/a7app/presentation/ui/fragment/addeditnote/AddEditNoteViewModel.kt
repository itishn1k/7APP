package com.example.a7app.presentation.ui.fragment.addeditnote

import androidx.lifecycle.ViewModel
import com.example.a7app.domain.model.Note
import com.example.a7app.domain.usecases.CreateNoteUseCase
import com.example.a7app.domain.usecases.EditNoteUseCase
import com.example.a7app.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AddEditNoteViewModel @Inject constructor(
    private val createNoteUseCase: CreateNoteUseCase,
    private val editNoteUseCase: EditNoteUseCase
) : ViewModel() {

    fun addNote(note: Note) {
        createNoteUseCase.createNote(note)
    }

    fun editNote(note: Note) {
        editNoteUseCase.editNote(note)
    }
}