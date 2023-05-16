package com.example.applab9


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders


class RestoreActivity : AppCompatActivity() {

    private lateinit var forgotEmailTextEdit: EditText
    private lateinit var codewordTextEdit: EditText
    private lateinit var restoreButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)

        val provider: ViewModelProvider = ViewModelProviders.of(this)
        val loginInfo = provider.get(LoginInfo::class.java)

        forgotEmailTextEdit = findViewById(R.id.forgotEmail_textEdit)
        codewordTextEdit = findViewById(R.id.codeword_textEdit)
        restoreButton = findViewById(R.id.restore_button)

        restoreButton.setOnClickListener {
            val text = if (!loginInfo.emailCheck(forgotEmailTextEdit.text.toString())) "Enter correct email"
            else if (codewordTextEdit.text.toString().isEmpty()) "Enter codeword"
            else if (forgotEmailTextEdit.text.toString() == loginInfo.email && codewordTextEdit.text.toString() == loginInfo.codeword)
                "Password for ${loginInfo.email} is ${loginInfo.password}"
            else "Wrong email or codeword"

            Toast.makeText(this, text, Toast.LENGTH_LONG).show()
        }

    }

}