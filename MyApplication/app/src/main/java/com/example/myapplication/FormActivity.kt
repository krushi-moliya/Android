package com.example.myapplication

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import java.util.*

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        //Email
        var email : EditText = findViewById(R.id.editTextEmail)
        var btn : Button = findViewById(R.id.button5)
        email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(!android.util.Patterns.EMAIL_ADDRESS.matcher(p0).matches())
                {
                    btn.isEnabled=false
                    email.setError("Invalid Input")
                }
                else
                {
                    btn.isEnabled=true
                }
            }

            override fun afterTextChanged(p0: Editable?) { }

        })

        //AutoCompleteTextView
        var actv : AutoCompleteTextView = findViewById(R.id.autoCompleteTextView)
        var university = arrayOf("Atmiya University","Marwadi University","RK University","Darshan University","Gujarat University")
        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,university)
        actv.setAdapter(adapter)

        //MultiAutoCompleteTextView
        var mactv : MultiAutoCompleteTextView = findViewById(R.id.multiAutoCompleteTextView)
        var skills = arrayOf("Web Develope","Web Design","Android App","Flutter","Data Structure")
        var skillsAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,skills)
        mactv.setAdapter(skillsAdapter)
        mactv.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())

        //Date
        var etDate : EditText = findViewById(R.id.editTextDate)
        var c = Calendar.getInstance()

        etDate.setOnClickListener {
            DatePickerDialog(this,DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
                etDate.setText("$year/${month+1}/$day")
            },c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show()
        }

        //Time
        var etTime : EditText = findViewById(R.id.editTextTime)

        etTime.setOnClickListener {
          TimePickerDialog(this,TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
              etTime.setText("$hour:$minute")
          },c.get(Calendar.HOUR),c.get(Calendar.MINUTE),true).show()
        }

        btn.setOnClickListener {
            var i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
    }
}