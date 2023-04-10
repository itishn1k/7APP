package com.example.a7app.presentation.ui.fragment.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a7app.domain.model.Note
import com.example.a7app.domain.usecases.DeleteNoteUseCase
import com.example.a7app.domain.usecases.GetAllNotesUseCase
import com.example.a7app.domain.utils.Resource
import com.example.a7app.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
) : ViewModel() {
    private val _getAllNotesState = MutableStateFlow<UIState<List<Note>>>(UIState.Empty())
    val getAllNotesState = _getAllNotesState.asStateFlow()

    fun getAllNotes() {
        viewModelScope.launch {
            getAllNotesUseCase.getAllNotes().collect {
                when (it) {
                    is Resource.Error -> {
                        _getAllNotesState.value = UIState.Error(it.message!!)
                    }
                    is Resource.Loading -> {
                        _getAllNotesState.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data != null) {
                            _getAllNotesState.value = UIState.Success(it.data)
                        }
                    }
                }
            }
        }
    }
}