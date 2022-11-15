package com.example.advancedtopics.Classes

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.advancedtopics.DataClass.Description
import com.example.advancedtopics.Interfaces.DescriptionDAO

@Database(entities = [Description::class],
    version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun descriptionDao(): DescriptionDAO
}