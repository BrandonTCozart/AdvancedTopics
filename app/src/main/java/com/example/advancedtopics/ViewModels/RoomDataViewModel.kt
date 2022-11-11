package com.example.advancedtopics.ViewModels


import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.example.advancedtopics.Classes.AppDatabase
import com.example.advancedtopics.DataClass.Description
import com.example.advancedtopics.Interfaces.DescriptionDAO

class roomDataViewModel(): ViewModel() {


    fun insertDesc(applicationContext: Context, description: Description){

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "description"
        ).build()

        val descriptionDao = db.descriptionDao()

        Thread(Runnable {
            descriptionDao.insertDescription(description)
        })

    }



    fun getSpecificDescription(applicationContext: Context, fname: String):String?{

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "description"
        ).build()

        val descriptionDao = db.descriptionDao()
        var description: String? = ""

        Thread(Runnable{
            var descriptionList = descriptionDao.getSpecific(fname)
            description = descriptionList.get(0).description
        })


        return description

    }

}