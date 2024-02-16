package com.devkaybee.smartparking.ui.driver.dashboard

import android.content.Intent
import android.health.connect.datatypes.units.Length
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.devkaybee.smartparking.data.api.ApiCall
import com.devkaybee.smartparking.data.api.Operability
import com.devkaybee.smartparking.data.api.SmSUpdate
import com.devkaybee.smartparking.data.api.UpdateStatus
import com.devkaybee.smartparking.databinding.ActivityBookingBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookingActivity : AppCompatActivity() {

    private lateinit var bookingBinding: ActivityBookingBinding
    private lateinit var operability: Operability
    private lateinit var location: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bookingBinding = ActivityBookingBinding.inflate(layoutInflater)
        setContentView(bookingBinding.root)

        operability = Operability()

        bookingBinding.addBookBtn.setOnClickListener {

            bookingBinding.bookStatusLayout.visibility = View.GONE

            val phoneNumber : String= bookingBinding.edtxtPhoneNumber.text.toString()
            val userName : String= bookingBinding.edtxtUserName.text.toString()

            val numberPlate : String= bookingBinding.edtxtNumberPlate.text.toString()
            val carType : String= bookingBinding.edtxtCarType.text.toString()



             val message: String = "Dear ${userName}, ticket number 734-A of Vehicle Registration: ${numberPlate} has been reserved! Please drive your way"

            location = intent.getStringExtra("EXTRA_LOCATION").toString()

             operability.SendSMS(phoneNumber, message)

            bookingBinding.BookConfirmedLayout.visibility = View.VISIBLE
           // Toast.makeText(applicationContext, "Message Sent")
            //bookingBinding.bookConfirmedLayout.visibility = View.VISIBLE
        }


        bookingBinding.navigateLocation.setOnClickListener {
            val gmmIntentUri = Uri.parse("google.navigation:q=${location!!}")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)

        }
    }

}