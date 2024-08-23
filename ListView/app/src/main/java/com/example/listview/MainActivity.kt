package com.example.listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listview : ListView = findViewById(R.id.listview)
        var city = arrayOf("Rajkot","Surat","Amhemadabad","Amreli")
        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,city)
        listview.adapter = adapter

        listview.setOnItemClickListener { adapterView, view, i, l ->
            var value = listview.getItemAtPosition(i).toString()
            //Toast.makeText(applicationContext,value,Toast.LENGTH_LONG).show()
           when(value)
           {
               "Rajkot"->{
                   var i = Intent(this,RajkotActivity::class.java)
                   startActivity(i)
               }
               "Surat"->{
                   var j = Intent(this,SuratActivity::class.java)
                   startActivity(j)
               }
               "Amreli"->{
                   var k = Intent(this,AmreliActivity::class.java)
                   startActivity(k)
               }
               "Amhemadabad"->{
                   var l = Intent(this,AhemadabActivity::class.java)
                   startActivity(l)
               }
           }

        }


    }
}