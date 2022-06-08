package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.otpview.OTPListener
import com.otpview.OtpTextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val otpView = findViewById<OtpTextView>(R.id.otpView)
        val buttonOk = findViewById<Button>(R.id.buttonOk)

        otpView.otpListener = object : OTPListener {
            override fun onInteractionListener() {
                if((otpView.otp?.length ?: 0) < 6) {
                    buttonOk.isEnabled = false
                }
            }

            override fun onOTPComplete(otp: String) {
                buttonOk.isEnabled = true
                Toast.makeText(this@MainActivity, "otp = $otp", Toast.LENGTH_SHORT).show()
            }

        }
    }
}