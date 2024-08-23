package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var btn_con : Button = findViewById(R.id.button)
        btn_con.setOnClickListener {
            var i = Intent(this,FormActivity::class.java)
            startActivity(i)
        }

        var btn_lin : Button = findViewById(R.id.button2)
        btn_lin.setOnClickListener {
            var i = Intent(this,LinkActivity::class.java)
            startActivity(i)
        }

        var btn_rel : Button = findViewById(R.id.button3)
        btn_rel.setOnClickListener {
            var i = Intent(this,ButtonActivity::class.java)
            startActivity(i)
        }

        var btn_frm : Button = findViewById(R.id.button4)
        btn_frm.setOnClickListener {
            var i = Intent(this,RateSeekActivity::class.java)
            startActivity(i)
        }
    }
}