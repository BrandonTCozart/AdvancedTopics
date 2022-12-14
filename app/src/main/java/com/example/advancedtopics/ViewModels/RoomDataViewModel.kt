package com.example.advancedtopics.ViewModels


import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.example.advancedtopics.Classes.AppDatabase
import com.example.advancedtopics.DataClass.Description
import com.example.advancedtopics.Interfaces.DescriptionDAO

class roomDataViewModel(): ViewModel() {


    // Create a LiveData with a String //
    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    var described: String = ""


    fun insertDesc(applicationContext: Context, description: Description){

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "description"
        ).build()

        val descriptionDao = db.descriptionDao()

        Thread(Runnable {
            try {
                descriptionDao.insertDescription(description)
            }catch (e: Exception){
                //Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
            }
        }).start()

        //Toast.makeText(applicationContext, "Inserted", Toast.LENGTH_SHORT).show()

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
            described = description!!
        }).start()

        while(description!!.isBlank()){
            // Do Nothing
        }

        return description

    }


    /*fun getAllFromDB(applicationContext: Context): List<Description>{

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "description"
        ).build()



        val descriptionDao = db.descriptionDao()

        var descriptionList:List<Description>

        Thread(Runnable{
            descriptionList = descriptionDao.getAll()
        }).start()


        return descriptionList

    }

     */

}