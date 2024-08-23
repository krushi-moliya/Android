package com.example.linearlayout_edittext_actv_mactv_date_time

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.MultiAutoCompleteTextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Email
        var etEmail : EditText = findViewById(R.id.editTextEmail)
        //ACTV
        var actvCity : AutoCompleteTextView = findViewById(R.id.actvCity)
        var city = arrayOf("Rajkot","Surat","Ahemadabad","Junagath","Jamanagr","Baroda")
        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,city)
        actvCity.setAdapter(adapter)

        //MACTV
        var mactvSkills : MultiAutoCompleteTextView = findViewById(R.id.mactvSkills)
        var skills = arrayOf("Web Design","Webb Development","Dev OPS","Android")
        var skillAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,skills)
        mactvSkills.setAdapter(skillAdapter)
        mactvSkills.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())

        etEmail.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(!android.util.Patterns.EMAIL_ADDRESS.matcher(p0).matches()){
                    etEmail.setError("Invalid Input")
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })


    }
}