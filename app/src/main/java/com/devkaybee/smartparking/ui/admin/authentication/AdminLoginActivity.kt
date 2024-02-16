package com.devkaybee.smartparking.ui.admin.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devkaybee.smartparking.R
import com.devkaybee.smartparking.databinding.ActivityAdminloginBinding
import com.devkaybee.smartparking.databinding.ActivityDriverLoginBinding
import com.devkaybee.smartparking.ui.onboarding.IntroActivity

class AdminLoginActivity : AppCompatActivity() {
    private lateinit var adminLoginBinding: ActivityAdminloginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adminLoginBinding = ActivityAdminloginBinding.inflate(layoutInflater)
        setContentView(adminLoginBinding.root)

        adminLoginBinding.backIcon.setOnClickListener {
            val intent = Intent(this, IntroActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}