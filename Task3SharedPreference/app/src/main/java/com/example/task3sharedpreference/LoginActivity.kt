package com.example.task3sharedpreference

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var et_unm : EditText = findViewById(R.id.et_unm)
        var et_pass : EditText = findViewById(R.id.et_pass)
        var btn_login : Button = findViewById(R.id.btn_login)
        var btn_reg : Button = findViewById(R.id.btn_reg)

        var sp= application.getSharedPreferences("logindata",Context.MODE_PRIVATE)
        var editor = sp.edit()

        btn_login.setOnClickListener{
            editor.putString("unm",et_unm.text.toString())
            editor.putString("pass",et_pass.text.toString())
            editor.commit()
            Toast.makeText(applicationContext,"Login Successfully!!!",Toast.LENGTH_LONG).show()
            et_unm.setText("")
            et_pass.setText("")
        }


        btn_reg.setOnClickListener{
            var i = Intent(this,RegistrationActivity::class.java)
            startActivity(i)
        }
    }
}