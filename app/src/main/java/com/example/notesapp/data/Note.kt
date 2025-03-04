package com.example.notesapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalDateTime

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val content: String,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val category: String,
    val priority: Priority,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    enum class Priority {
        LOW, MEDIUM, HIGH
    }
}