package com.example.notesapp.data

import kotlinx.coroutines.flow.Flow

class NoteRepository(private val noteDao: NoteDao) {
    fun getAllNotesSorted(sortBy: String): Flow<List<Note>> = 
        noteDao.getNotesSorted(sortBy)

    fun getNotesByCategory(category: String): Flow<List<Note>> = 
        noteDao.getNotesByCategory(category)

    suspend fun addNote(note: Note) = noteDao.insert(note)

    suspend fun updateNote(note: Note) = noteDao.update(note)

    suspend fun deleteNote(note: Note) = noteDao.delete(note)

    fun getCategories(): List<String> = listOf("Work", "Personal", "Shopping")
}