package com.example.task3sharedpreference

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import java.util.*

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)


        var et_srm : EditText = findViewById(R.id.et_srm)
        var et_nm : EditText = findViewById(R.id.et_nm)
        var et_email : EditText = findViewById(R.id.et_email)
        var et_pass : EditText = findViewById(R.id.et_pass)
        var et_dob : EditText = findViewById(R.id.et_dob)
        var gender : RadioGroup = findViewById(R.id.gender)
        var actv_city : AutoCompleteTextView = findViewById(R.id.actv_city)
        var btn_login : Button = findViewById(R.id.btn_login)


        //Email
        et_email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(!android.util.Patterns.EMAIL_ADDRESS.matcher(p0).matches())
                {
                    btn_login.isEnabled=false
                    et_email.setError("Invalid Input")
                }
                else
                {
                    btn_login.isEnabled=true
                }
            }

            override fun afterTextChanged(p0: Editable?) { }

        })

        //AutoCompleteTextView
        var city : AutoCompleteTextView = findViewById(R.id.actv_city)
        var cities = arrayOf("Rajkot","Surat","Ahemadabad","Amareli","Baroda")
        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,cities)
        city.setAdapter(adapter)

        //Date
        var c = Calendar.getInstance()

        et_dob.setOnClickListener {
            DatePickerDialog(this, DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
                et_dob.setText("$year/${month+1}/$day")
            },c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show()
        }

        //Gender
        var str:String=""
        gender.setOnCheckedChangeListener { radioGroup, i ->
            var rb = findViewById<RadioButton>(i)
            str=rb.text.toString()
        }


//        btn_login.setOnClickListener{
//            var i = Intent(this,DataActivity::class.java)
//
//            i.putExtra("surname",et_srm.text.toString())
//            i.putExtra("name",et_nm.text.toString())
//            i.putExtra("email",et_email.text.toString())
//            i.putExtra("password",et_pass.text.toString())
//            i.putExtra("dob",et_dob.text.toString())
//            i.putExtra("gender",str)
//            i.putExtra("city",actv_city.text.toString())
//
//            startActivity(i)
//        }

        var sp= application.getSharedPreferences("logindata",Context.MODE_PRIVATE)
        var editor = sp.edit()

        btn_login.setOnClickListener{
            editor.putString("surname",et_srm.text.toString())
            editor.putString("name",et_nm.text.toString())
            editor.putString("email",et_email.text.toString())
            editor.putString("password",et_pass.text.toString())
            editor.putString("date",et_dob.text.toString())
            editor.putString("gender",str)
            editor.putString("city",actv_city.text.toString())
            editor.commit()

            Toast.makeText(applicationContext,"Login Successfully!!!",Toast.LENGTH_LONG).show()
            et_srm.setText("")
            et_nm.setText("")
            et_email.setText("")
            et_pass.setText("")
            et_dob.setText("")
            actv_city.setText("")

            var i = Intent(this,DataActivity::class.java)
            startActivity(i)

        }

    }

}