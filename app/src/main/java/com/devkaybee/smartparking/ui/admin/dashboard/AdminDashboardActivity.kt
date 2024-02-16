package com.devkaybee.smartparking.ui.admin.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.devkaybee.smartparking.R
import com.devkaybee.smartparking.databinding.ActivityAdminDashboardBinding

class AdminDashboardActivity : AppCompatActivity() {
    private lateinit var adminDashboardBinding: ActivityAdminDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adminDashboardBinding = ActivityAdminDashboardBinding.inflate(layoutInflater)
        setContentView(adminDashboardBinding.root)

        val bottomNav = adminDashboardBinding.bottomNavBar
        val navController = findNavController(R.id.homeContainer)
        bottomNav.setupWithNavController(navController)
    }
}