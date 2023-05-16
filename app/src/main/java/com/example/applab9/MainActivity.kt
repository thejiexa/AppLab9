package com.example.applab9


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import android.provider.ContactsContract.*
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Patterns


class MainActivity : AppCompatActivity() {

    private lateinit var loginButton: Button
    private lateinit var emailTextEdit: EditText
    private lateinit var passwordTextEdit: EditText
    private lateinit var forgotPasswordTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val provider: ViewModelProvider = ViewModelProviders.of(this)
        val loginInfo = provider.get(LoginInfo::class.java)

        loginButton = findViewById(R.id.button_Login)
        emailTextEdit = findViewById(R.id.email_EditText)
        passwordTextEdit = findViewById(R.id.password_EditText)
        forgotPasswordTextView = findViewById(R.id.forgot_password)

        loginButton.setOnClickListener {
            val text = if (!loginInfo.emailCheck(emailTextEdit.text.toString())) "Enter correct email"
            else if (passwordTextEdit.text.toString().isEmpty()) "Enter password"
            else if (emailTextEdit.text.toString() == loginInfo.email && passwordTextEdit.text.toString() == loginInfo.password) "Logged In"
            else "Wrong email or password"

            if (text == "Logged In") this.startActivity(Intent(this, LoggedInActivity::class.java))
            else Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }

        forgotPasswordTextView.setOnClickListener{
            this.startActivity(Intent(this, RestoreActivity::class.java))
        }
    }
}


