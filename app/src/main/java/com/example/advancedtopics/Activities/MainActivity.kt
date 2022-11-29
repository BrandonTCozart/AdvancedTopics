package com.example.advancedtopics.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.advancedtopics.Interfaces.IActivityTransaction
import com.example.advancedtopics.R
import com.example.advancedtopics.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), IActivityTransaction {

    // private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val navController = findNavController(R.id.nav_host_fragment_content_main)
        /*

        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

         */



        /*
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube")

            if(launchIntent != null){
                startActivity(launchIntent)
            }else{

            }
         */


    }

    override fun toNewApplication() {

        var launchIntent: Intent? = packageManager.getLaunchIntentForPackage("com.example.koylinfasten")

        if(launchIntent != null){
            startActivity(launchIntent)
        }else{

        }

    }



}