package com.example.a7app.presentation.ui.fragment.notes

import com.example.a7app.domain.model.Note
import com.example.a7app.domain.usecases.DeleteNoteUseCase
import com.example.a7app.domain.usecases.GetAllNotesUseCase
import com.example.a7app.presentation.ui.base.BaseViewModel
import com.example.a7app.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
) : BaseViewModel() {

    private val _getAllNotesState = MutableStateFlow<UIState<List<Note>>>(UIState.Empty())
    val getAllNotesState = _getAllNotesState.asStateFlow()

    private val _deleteNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val deleteNoteState = _deleteNoteState.asStateFlow()

    fun getAllNotes() = getAllNotesUseCase.getAllNotes().collectData(_getAllNotesState)


    fun deleteNote(note: Note) = deleteNoteUseCase.deleteNote(note).collectData(_deleteNoteState)

}