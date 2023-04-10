package com.example.a7app.presentation.ui.fragment.addeditnote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.a7app.App
import com.example.a7app.R
import com.example.a7app.data.local.NoteDao
import com.example.a7app.data.local.NoteDataBase
import com.example.a7app.databinding.FragmentAddEditNoteBinding
import com.example.a7app.databinding.FragmentNotesBinding
import com.example.a7app.domain.model.Note
import com.example.a7app.presentation.ui.fragment.notes.NotesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddEditNoteFragment : Fragment() {
    private val viewModel by viewModels<AddEditNoteViewModel>()
    private var _binding: FragmentAddEditNoteBinding? = null
    private val binding get() = _binding!!
    private var note: Note? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddEditNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        binding.btnSave.setOnClickListener {
            when (note) {
                null -> {
                    save()
                }
                else -> {
                    edit()
                }
            }
            findNavController().navigateUp()
        }
    }
//    private fun edit() {
//        note?.title = binding.etTitle.text.toString()
//        task?.desc = binding.etDesc.text.toString()
//        task?.let { App.db.dao().update(it) }
//    }

    private fun save() {
        val data = Note(
            title = binding.etTitle.text.toString(),
            description = binding.etDesc.text.toString()
        )
        viewModel.addNote(data)
    }

    private fun edit() {
        val data = Note(
            title = binding.etTitle.text.toString(),
            description = binding.etDesc.text.toString()
        )
        viewModel.editNote(data)
    }
}