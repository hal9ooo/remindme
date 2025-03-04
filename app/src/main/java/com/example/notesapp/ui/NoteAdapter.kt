package com.example.notesapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.data.Note
import com.example.notesapp.databinding.ItemNoteBinding
import java.time.format.DateTimeFormatter

class NoteAdapter(private val onItemClick: (Note) -> Unit) : 
    ListAdapter<Note, NoteAdapter.NoteViewHolder>(NoteDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemNoteBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class NoteViewHolder(private val binding: ItemNoteBinding) : 
        RecyclerView.ViewHolder(binding.root) {
            
        fun bind(note: Note) {
            binding.apply {
                textTitle.text = note.title
                textDate.text = note.endDate.format(DateTimeFormatter.ISO_DATE)
                textCategory.text = note.category
                
                val priorityColor = when(note.priority) {
                    Note.Priority.HIGH -> R.color.red
                    Note.Priority.MEDIUM -> R.color.orange
                    Note.Priority.LOW -> R.color.green
                }
                priorityIndicator.setBackgroundColor(
                    root.context.getColor(priorityColor)
                )
                
                root.setOnClickListener { onItemClick(note) }
            }
        }
    }

    class NoteDiffCallback : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note) = 
            oldItem.id == newItem.id
            
        override fun areContentsTheSame(oldItem: Note, newItem: Note) = 
            oldItem == newItem
    }
}