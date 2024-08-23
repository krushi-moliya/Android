package com.example.listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AhemadabActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ahemadab)


        var btnah : Button = findViewById(R.id.button)

        btnah.setOnClickListener {
            var i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
    }
}