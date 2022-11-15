package com.example.advancedtopics.Services

import android.app.Service
import android.content.Intent
import android.os.IBinder

class foregroundService : Service() {

    override fun onStart(intent: Intent?, startId: Int) {

    }


    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}