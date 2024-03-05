package com.example.signup_signin_firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

lateinit var database : DatabaseReference
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signupButton = findViewById<Button>(R.id.btnSignUp)
        val tetName = findViewById<EditText>(R.id.etName)
        val tetEmail = findViewById<EditText>(R.id.etEmail)
        val tetPassword = findViewById<EditText>(R.id.etPassword)
        val tetNumber = findViewById<EditText>(R.id.etCall)

        signupButton.setOnClickListener {
            val name = tetName.text.toString()
            val email = tetEmail.text.toString()
            val pass = tetPassword.text.toString()
            val number = tetNumber.text.toString()
            val user = User(name,email,pass,number)
            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(number).setValue(user).addOnSuccessListener {
                tetName.text?.clear()
                tetEmail.text?.clear()
                tetPassword.text?.clear()
                tetNumber.text?.clear()
                Toast.makeText(this,"User registered",Toast.LENGTH_SHORT)
            }
        }
    }
}