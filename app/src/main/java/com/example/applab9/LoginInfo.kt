package com.example.applab9

import android.util.Patterns
import android.provider.ContactsContract.*
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.lifecycle.ViewModel

class LoginInfo : ViewModel() {

    var email = "alexey@gmail.com"
    var password = "alexey1"
    var codeword = "somecode"

    fun emailCheck(email: String) : Boolean = !email.isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
}