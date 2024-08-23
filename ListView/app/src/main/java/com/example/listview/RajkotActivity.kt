package com.example.listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RajkotActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rajkot)

        var btnr : Button = findViewById(R.id.button3)

        btnr.setOnClickListener {
            var i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
    }
}