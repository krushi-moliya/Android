package com.example.registrationactivity

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import java.util.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var btn : Button = findViewById(R.id.button)

        var uName : EditText = findViewById(R.id.editTextTextPersonName)

        //Email
        var email : EditText = findViewById(R.id.editTextTextEmailAddress)
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
        var city : AutoCompleteTextView = findViewById(R.id.autoCompleteTextView)
        var cities = arrayOf("Rajkot","Surat","Ahemadabad","Amareli","Baroda")
        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,cities)
        city.setAdapter(adapter)

        //MultiAutoCompleteTextView
        var hobby : MultiAutoCompleteTextView = findViewById(R.id.multiAutoCompleteTextView)
        var hobbies = arrayOf("Travelling","Reading","Writing","Dancing","Drawing")
        var skillsAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,hobbies)
        hobby.setAdapter(skillsAdapter)
        hobby.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())

        //Date
        var etDate : EditText = findViewById(R.id.editTextDate)
        var c = Calendar.getInstance()

        etDate.setOnClickListener {
            DatePickerDialog(this,DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
                etDate.setText("$year/${month+1}/$day")
            },c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show()
        }

        //Gender
        var str:String=""
        var gender : RadioGroup = findViewById(R.id.radioGroup)
        gender.setOnCheckedChangeListener { radioGroup, i ->
            var rb = findViewById<RadioButton>(i)
            str=rb.text.toString()
        }

        btn.setOnClickListener{
            var i = Intent(this,DetailsActivity::class.java)
            i.putExtra("name",uName.text.toString())
            i.putExtra("email",email.text.toString())
            i.putExtra("hobbies",hobby.text.toString())
            i.putExtra("city",city.text.toString())
            i.putExtra("gender",str)
            i.putExtra("date",etDate.text.toString())

            startActivity(i)
        }

    }
}