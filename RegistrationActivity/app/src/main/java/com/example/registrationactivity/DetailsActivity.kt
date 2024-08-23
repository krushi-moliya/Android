package com.example.registrationactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        var txtName : TextView = findViewById(R.id.textView10)
        var txtEmail : TextView = findViewById(R.id.textView11)
        var txtHobby : TextView = findViewById(R.id.textView12)
        var txtCity : TextView = findViewById(R.id.textView13)
        var txtGender : TextView = findViewById(R.id.textView14)
        var txtDate: TextView = findViewById(R.id.textView15)

        var intent: Intent = intent
        var name = intent.getStringExtra("name")
        txtName.setText("Name : "+name)

        var email = intent.getStringExtra("email")
        txtEmail.setText("Email : "+email)

        var hobby = intent.getStringExtra("hobby")
        txtHobby.setText("Hobbies : "+hobby)

        var city = intent.getStringExtra("city")
        txtCity.setText("City : "+city)

        var gender = intent.getStringExtra("gender")
        txtGender.setText("Gender : "+gender)

        var date = intent.getStringExtra("date")
        txtDate.setText("Birth date : "+date)


    }
}