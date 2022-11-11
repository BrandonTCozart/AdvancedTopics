package com.example.advancedtopics.Interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.advancedtopics.DataClass.Description

@Dao
interface DescriptionDAO { // DAO Stands for Data Access Object //

    @Query("SELECT * FROM description")
    fun getAll(): List<Description>

    @Query("SELECT * FROM description WHERE first_name LIKE :Fname")
    fun getSpecific(Fname: String): List<Description>

    @Insert
    fun insertDescription(newDesc: Description)

    //@Delete
}