package com.example.applab9

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

class LoggedInActivity : AppCompatActivity() {

    private lateinit var loggedinTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loggedin)

        val provider: ViewModelProvider = ViewModelProviders.of(this)
        val loginInfo = provider.get(LoginInfo::class.java)

        loggedinTextView = findViewById(R.id.loggedIn_TextView)
        loggedinTextView.text = "${loginInfo.email} Logged In"

    }

}