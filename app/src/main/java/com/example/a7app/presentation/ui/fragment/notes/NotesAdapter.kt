package com.example.a7app.presentation.ui.fragment.notes

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.a7app.databinding.ItemNotesBinding
import com.example.a7app.domain.model.Note

class NotesAdapter(
    private val onLongClick: (Note) -> Unit,
    private val onClick: (Note) -> Unit
) : ListAdapter<Note, NotesAdapter.NotesViewHolder>(DiffUtilItemCallback()) {


    inner class NotesViewHolder(
        private val binding: ItemNotesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            binding.tvTitle.text = note.title
            binding.tvDesc.text = note.description
            itemView.setOnClickListener {
                onClick(note)
            }
            itemView.setOnLongClickListener {
                onLongClick(note)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            ItemNotesBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: NotesAdapter.NotesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    @SuppressLint("DiffUtilEquals")
    private class DiffUtilItemCallback : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }
    }
}