package com.example.a7app.presentation.ui.fragment.createeditnote

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.a7app.R
import com.example.a7app.databinding.FragmentCreateEditNoteBinding
import com.example.a7app.domain.model.Note
import com.example.a7app.presentation.ui.base.BaseFragment
import com.example.a7app.presentation.utils.Constants.KEY_EDIT_NOTE
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateEditNoteFragment :
    BaseFragment<FragmentCreateEditNoteBinding, CreateEditNoteViewModel>(R.layout.fragment_create_edit_note) {

    override val viewModel: CreateEditNoteViewModel by viewModels()
    override val binding by viewBinding(FragmentCreateEditNoteBinding::bind)
    private var note: Note? = null
    private var isEditingExistingNote = false

    override fun init() {
        super.init()
        getNote()
    }

    override fun setSubscribers() {
        super.setSubscribers()
        collectCreateNoteState()
        collectEditNoteState()
    }

    override fun initListeners() {
        super.initListeners()
        createOrEditNote()
    }

    private fun createOrEditNote() {
        with(binding) {
            btnSave.setOnClickListener {
                val title = etTitle.text.toString()
                val description = etDesc.text.toString()

                if (title.isNotEmpty() || description.isNotEmpty()) {
                    note?.let {
                        it.title = title
                        it.description = description

                        if (isEditingExistingNote) {
                            viewModel.editNote(it)
                        } else {
                            viewModel.createNote(it)
                        }
                    }
                }
            }
        }
    }

    @Suppress("DEPRECATION")
    private fun getNote() {
        if (arguments?.getSerializable(KEY_EDIT_NOTE) != null) {
            note = arguments?.getSerializable(KEY_EDIT_NOTE) as Note
            with(binding) {
                etTitle.setText(note!!.title)
                etDesc.setText(note!!.description)
                btnSave.text = getString(R.string.edit)
            }
            isEditingExistingNote = true
        } else {
            note = Note()
        }
    }

    private fun collectCreateNoteState() {
        viewModel.createNoteState.collectUIState(
            uiState = {

            },
            onSuccess = {
                findNavController().navigateUp()
            }
        )
    }

    private fun collectEditNoteState() {
        viewModel.editNoteState.collectUIState(
            uiState = {

            },
            onSuccess = {
                findNavController().navigateUp()
            }
        )
    }
}