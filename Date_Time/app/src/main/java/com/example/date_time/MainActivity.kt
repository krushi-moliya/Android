package com.example.date_time

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.EditText
import java.util.*
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var etDate: EditText = findViewById(R.id.editTextDate)
    var c = Calendar.getInstance()

    etDate.setOnClickListener
    {
        DatePickerDialog(
            this, DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                etDate.setText("$i3/${i2 + 1}/$i")
            },
            c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)
        ).show()
    }
}






























}