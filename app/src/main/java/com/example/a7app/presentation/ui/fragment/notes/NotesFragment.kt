package com.example.a7app.presentation.ui.fragment.notes

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.a7app.R
import com.example.a7app.databinding.FragmentNotesBinding
import com.example.a7app.domain.model.Note
import com.example.a7app.presentation.utils.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NotesFragment : Fragment() {

    private val viewModel by viewModels<NotesViewModel>()
    private var _binding: FragmentNotesBinding? = null
    private lateinit var adapter: NotesAdapter
    private val binding get() = _binding!!
    private lateinit var notesList : List<Note>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = NotesAdapter(this::onLongClick, this::onClick)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setRequests()
        setSubscribers()
        initListeners()
    }

    private fun init() {
    }

    private fun initListeners() {
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.addEditNoteFragment)
        }
    }

    private fun setSubscribers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getAllNotesState.collect {
                    when (it) {
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                        }
                        is UIState.Loading -> {
                            //TODO(ShowProgressBar)
                        }
                        is UIState.Success -> {
                            adapter.addNotes(it.data)
                        }
                    }
                }
            }
        }
    }

    private fun setRequests() {
        viewModel.getAllNotes()
    }

    private fun onLongClick(note: Note) {
//        val builder = AlertDialog.Builder(requireContext())
//        if (requireContext().isNetworkConnected()) { //homework7
//            builder.setTitle("Sorry")
//            builder.setMessage("Deleting unavailable now")
//            builder.show()
//        } else {
//            builder.setTitle("Delete")
//            builder.setMessage("Are you sure you want to delete this note?")
//
//
//            builder.setPositiveButton("Yes") { _: DialogInterface, _: Int ->
//                App.db.dao().delete(task)
//                setData()
//            }
//
//            builder.setNegativeButton("No") { _: DialogInterface, _: Int ->
//            }
//            builder.show()
//        }
    }

    private fun onClick(note: Note) {
//        if (requireContext().isNetworkConnected()) {//homework7
//            showToast("Editing unavailable now")
//        } else {
//            findNavController().navigate(R.id.navigation_task, bundleOf(KEY_FOR_TASK to task))
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}