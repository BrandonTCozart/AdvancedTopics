package com.example.advancedtopics.Tests

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.advancedtopics.Classes.AppDatabase
import com.example.advancedtopics.Interfaces.DescriptionDAO
import com.example.advancedtopics.ViewModels.roomDataViewModel
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class testClass {


    private lateinit var viewModel: roomDataViewModel
    private lateinit var db: AppDatabase
    private lateinit var descriptionDao: DescriptionDAO
    private lateinit var context: Context

    // Before keyword makes sure this runs before every test case
    @Before
    fun setup(){
        viewModel = roomDataViewModel()
        context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java).build()
        descriptionDao = db.descriptionDao()
    }


    @Test
    fun descriptionReturn(){
        viewModel.getSpecificDescription(context, "Brandon")
        assert(viewModel.getSpecificDescription(context, "Brandon")!!.isNotBlank())
    }

}