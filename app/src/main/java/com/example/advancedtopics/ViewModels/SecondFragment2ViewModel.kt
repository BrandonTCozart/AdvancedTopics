package com.example.advancedtopics.ViewModels

import androidx.lifecycle.ViewModel
import com.example.advancedtopics.Classes.Profile
import com.example.advancedtopics.DataModel.ProfileRealmDataModel
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import java.util.*

class SecondFragment2ViewModel: ViewModel() {
    lateinit var realm: Realm


    // Writes New Items to database //
    fun writeNewNoteToDatabase(name: String,profileAge: String, profileBio: String){

        val config = RealmConfiguration.Builder(schema = setOf(ProfileRealmDataModel()::class))
            .build()
        realm = Realm.open(config)

        var calendar: Calendar = Calendar.getInstance()

        realm.writeBlocking {
            copyToRealm(ProfileRealmDataModel().apply {
                displayName = name
                age = profileAge
                bio = profileBio
                accountCreationDate = calendar.time.toString()
            })
        }
        realm.close()
    }


    // Returns updated arraylist from the database //
    fun updateListOfProfiles(): ArrayList<Profile> {
        val config = RealmConfiguration.Builder(schema = setOf(ProfileRealmDataModel()::class))
            .build()
        realm = Realm.open(config)

        var items: RealmResults<ProfileRealmDataModel> = realm.query<ProfileRealmDataModel>().find()
        var profiles: ArrayList<Profile> = ArrayList()
        for(position in items){
            profiles.add(Profile(position.displayName, position.age, position.bio,position.accountCreationDate))
        }
        realm.close()
        return profiles
    }








}