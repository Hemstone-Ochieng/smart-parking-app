package com.devkaybee.smartparking.ui.driver.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devkaybee.smartparking.databinding.ActivityDriverLoginBinding
import com.devkaybee.smartparking.ui.onboarding.IntroActivity

class DriverLoginActivity : AppCompatActivity() {
    private lateinit var driverLoginBinding: ActivityDriverLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        driverLoginBinding =ActivityDriverLoginBinding.inflate(layoutInflater)
        setContentView(driverLoginBinding.root)

        driverLoginBinding.backIcon.setOnClickListener {
            val intent = Intent(this, IntroActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}