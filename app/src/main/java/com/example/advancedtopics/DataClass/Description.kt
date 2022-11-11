package com.example.advancedtopics.DataClass

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Description(
    @PrimaryKey var dID: Int,
    @ColumnInfo(name = "first_name")  val firstName: String?,
    @ColumnInfo(name = "description") val description: String?
)
