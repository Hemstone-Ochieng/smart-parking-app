package com.devkaybee.smartparking.ui.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devkaybee.smartparking.databinding.ActivityIntroBinding
import com.devkaybee.smartparking.ui.admin.dashboard.AdminDashboardActivity
import com.devkaybee.smartparking.ui.admin.dashboard.TestActivity
import com.devkaybee.smartparking.ui.driver.authentication.DriverLoginActivity

class IntroActivity : AppCompatActivity() {
    private lateinit var introBinding: ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        introBinding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(introBinding.root)

        introBinding.adminLoginBtn.setOnClickListener {
            val intent = Intent(this, AdminDashboardActivity::class.java)
            startActivity(intent)
        }

        introBinding.driverLoginBtn.setOnClickListener {
            val intent = Intent(this, TestActivity::class .java)
            startActivity(intent)
        }
    }
}