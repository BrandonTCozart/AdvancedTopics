package com.example.advancedtopics.DataModel

import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class ProfileRealmDataModel(): RealmObject {

    var displayName: String = ""
    var age: String = ""
    var bio: String = ""
    @PrimaryKey
    var userId: ObjectId = ObjectId.create()
    var accountCreationDate = ""

}