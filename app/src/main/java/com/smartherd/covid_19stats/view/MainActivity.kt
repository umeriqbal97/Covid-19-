package com.smartherd.covid_19stats.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.smartherd.covid_19stats.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView=findViewById<BottomNavigationView>(R.id.nav_bar)

        val navController=Navigation.findNavController(this,R.id.nav_host_fragment)

        NavigationUI.setupWithNavController(bottomNavigationView,navController)
    }
}
