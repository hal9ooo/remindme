package com.example.notesapp.data

import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Converters {
    private val dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE
    private val dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

    @TypeConverter
    fun fromLocalDate(value: LocalDate): String = value.format(dateFormatter)

    @TypeConverter
    fun toLocalDate(value: String): LocalDate = LocalDate.parse(value, dateFormatter)

    @TypeConverter
    fun fromLocalDateTime(value: LocalDateTime): String = value.format(dateTimeFormatter)

    @TypeConverter
    fun toLocalDateTime(value: String): LocalDateTime = LocalDateTime.parse(value, dateTimeFormatter)
}
