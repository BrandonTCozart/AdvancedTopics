package com.example.advancedtopics.Services

import android.app.Service
import android.content.Intent
import android.os.IBinder

class foregroundService : Service() {

    override fun onStart(intent: Intent?, startId: Int) {

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return Service.START_NOT_STICKY

    }


    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
        return  null
    }
}