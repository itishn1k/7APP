package com.example.a7app.presentation.ui.fragment.createeditnote

import com.example.a7app.domain.model.Note
import com.example.a7app.domain.usecases.CreateNoteUseCase
import com.example.a7app.domain.usecases.EditNoteUseCase
import com.example.a7app.presentation.ui.base.BaseViewModel
import com.example.a7app.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CreateEditNoteViewModel @Inject constructor(
    private val createNoteUseCase: CreateNoteUseCase,
    private val editNoteUseCase: EditNoteUseCase
) : BaseViewModel() {

    private val _createNoteState =
        MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val createNoteState = _createNoteState.asStateFlow()

    private val _editNoteState =
        MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val editNoteState = _editNoteState.asStateFlow()

    fun createNote(note: Note) =
        createNoteUseCase.createNote(note).collectData(_createNoteState)

    fun editNote(note: Note) =
        editNoteUseCase.editNote(note).collectData(_editNoteState)

}