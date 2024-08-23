package com.example.task3sharedpreference

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class DataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)


        var srm : EditText = findViewById(R.id.et_srm)
        var nm : EditText = findViewById(R.id.et_nm)
        var email : EditText = findViewById(R.id.et_email)
        var dob : EditText = findViewById(R.id.et_dob)
        var pass: EditText = findViewById(R.id.et_pass)
        var city: EditText = findViewById(R.id.actv_city)
        var edit : Button = findViewById(R.id.btn_display)

        var sp= application.getSharedPreferences("logindata", Context.MODE_PRIVATE)
        var editor = sp.edit()

        srm.setText(sp.getString("surname",""))
        nm.setText(sp.getString("name",""))
        email.setText(sp.getString("email",""))
        pass.setText(sp.getString("password",""))
        dob.setText(sp.getString("date",""))
        city.setText(sp.getString("city",""))


        edit.setOnClickListener {
            editor.putString("surname",srm.text.toString())
            editor.putString("name",nm.text.toString())
            editor.putString("email",email.text.toString())
            editor.putString("password",pass.text.toString())
            editor.putString("date",dob.text.toString())
            editor.putString("city",city.text.toString())
            editor.commit()

            Toast.makeText(applicationContext,"Data Saved!!!",Toast.LENGTH_LONG).show()
            srm.setText("")
            nm.setText("")
            email.setText("")
            pass.setText("")
            dob.setText("")
            city.setText("")

        }


    }
}