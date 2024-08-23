package com.example.filehandling

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txt : EditText = findViewById(R.id.editTextTextMultiLine)
        var btn_write : Button = findViewById(R.id.btn_write)
        var btn_read : Button = findViewById(R.id.btn_read)

        var builder = AlertDialog.Builder(this)
        btn_write.setOnClickListener {
            var fop = openFileOutput("myFile", Context.MODE_PRIVATE)
            fop.write(txt.text.toString().toByteArray())
            builder.setTitle("FILE HANDLING")
            builder.setMessage("Data Saved!!!")
            builder.setPositiveButton("OK",DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(applicationContext,i.toString(),Toast.LENGTH_LONG).show()
            })
            builder.setNegativeButton("CANCLE",DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(applicationContext,i.toString(),Toast.LENGTH_LONG).show()
            })
            builder.setNeutralButton("CLOSE",DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(applicationContext,i.toString(),Toast.LENGTH_LONG).show()
            })
            builder.show()
            txt.setText("")
        }

        btn_read.setOnClickListener {
            var line : String? = ""
            var fip = application.openFileInput("myFile")
            var br = BufferedReader(InputStreamReader(fip))
            while(line != null){
                line = br.readLine()
                Toast.makeText(applicationContext,line,Toast.LENGTH_LONG).show()
                if(line != null){
                    txt.append(line+"\n")
            }
        }
            builder.setTitle("FILE HANDLING")
            builder.setMessage("Data Saved!!!")
            builder.setPositiveButton("OK",DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(applicationContext,i.toString(),Toast.LENGTH_LONG).show()
            })
            builder.setNegativeButton("CANCLE",DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(applicationContext,i.toString(),Toast.LENGTH_LONG).show()
            })
            builder.setNeutralButton("CLOSE",DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(applicationContext,i.toString(),Toast.LENGTH_LONG).show()
            })
            builder.show()
            txt.setText("")


        }
    }
}