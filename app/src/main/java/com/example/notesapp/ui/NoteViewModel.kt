package com.example.notesapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.data.Note
import com.example.notesapp.data.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(private val repository: NoteRepository) : ViewModel() {
    private var currentSort = "date"
    private var currentCategory: String? = null
    
    fun getNotes() = when {
        currentCategory != null -> repository.getNotesByCategory(currentCategory!!)
        else -> repository.getAllNotesSorted(currentSort)
    }

    fun addNote(note: Note) = viewModelScope.launch {
        repository.addNote(note)
    }

    fun updateNote(note: Note) = viewModelScope.launch {
        repository.updateNote(note)
    }

    fun deleteNote(note: Note) = viewModelScope.launch {
        repository.deleteNote(note)
    }

    fun setSortOrder(sortBy: String) {
        currentSort = sortBy
    }

    fun setCategoryFilter(category: String?) {
        currentCategory = category
    }

    fun getCategories() = repository.getCategories()
}