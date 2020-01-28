package com.example.bookdocapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.doctor.room.AppDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private var db: AppDatabase? = null

    private var viewModel: MainActivityViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setViewModel()
        configureToolBar()
        configureNavController()
    }

    override fun onSupportNavigateUp(): Boolean =
        findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration)


    private fun configureToolBar() {
        setSupportActionBar(findViewById(R.id.toolbar))
    }

    private fun configureNavController() {
        findNavController(R.id.nav_host_fragment).let {
            appBarConfiguration = AppBarConfiguration(setOf(R.id.mainFragment))
            setupActionBarWithNavController(it, appBarConfiguration)
        }
    }

    fun setViewModel() {
        viewModel = ViewModelProviders.of(this)[MainActivityViewModel::class.java]
    }


}
