package com.example.a7app.presentation.ui.fragment.notes

import android.app.AlertDialog
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.a7app.R
import com.example.a7app.databinding.FragmentNotesBinding
import com.example.a7app.domain.model.Note
import com.example.a7app.domain.utils.Resource
import com.example.a7app.presentation.ui.base.BaseFragment
import com.example.a7app.presentation.utils.Constants.KEY_EDIT_NOTE
import com.example.a7app.presentation.utils.UIState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesFragment :
    BaseFragment<FragmentNotesBinding, NotesViewModel>(R.layout.fragment_notes) {

    override val viewModel by viewModels<NotesViewModel>()
    override val binding by viewBinding(FragmentNotesBinding::bind)
    private val notesAdapter by lazy { NotesAdapter(this::onLongClick, this::onClick) }

    override fun init() {
        binding.rvNotes.adapter = notesAdapter
    }

    override fun setRequests() {
        getAllNotesRequest()
    }

    private fun getAllNotesRequest() {
        viewModel.getAllNotes()
    }

    override fun setSubscribers() {
        viewModel.getAllNotesState.collectUIState(
            uiState = {
                binding.progressBar.isVisible = it is UIState.Loading
            },
            onSuccess = {
                notesAdapter.submitList(it)
            }
        )
        viewModel.deleteNoteState.collectUIState(
            uiState = {
                binding.progressBar.isVisible = it is UIState.Loading
            },
            onSuccess = {
                getAllNotesRequest()
            }
        )
    }

    override fun initListeners() {
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.createEditNoteFragment)
        }
    }

    private fun onLongClick(note: Note) {
        val builder = AlertDialog.Builder(requireContext())
        with(builder) {
            setTitle(getString(R.string.delete_note))
            setPositiveButton(getString(R.string.yes_)) { _, _ ->
                viewModel.deleteNote(note)
                Toast.makeText(
                    requireContext(), getString(R.string.note_deleted), Toast.LENGTH_SHORT
                ).show()
            }
            setNegativeButton(getString(R.string.no)) { n, _ ->
                n.cancel()
            }
        }.show()
    }

    private fun onClick(note: Note) {
        findNavController().navigate(
            R.id.createEditNoteFragment, bundleOf(KEY_EDIT_NOTE to note)
        )
    }
}