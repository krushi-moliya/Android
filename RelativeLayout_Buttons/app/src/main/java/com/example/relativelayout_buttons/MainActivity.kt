package com.example.relativelayout_buttons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn : Button = findViewById(R.id.button)
        var imgbtn : ImageButton = findViewById(R.id.imageButton)
        var tglbtn : ToggleButton = findViewById(R.id.toggleButton)
        var imgView : ImageView = findViewById(R.id.imageView)
        var fab : FloatingActionButton = findViewById(R.id.floatingActionButton)


        btn.setOnClickListener {
            Toast.makeText(applicationContext,"Button clicked",Toast.LENGTH_LONG).show()
        }

        imgbtn.setOnClickListener{
            Toast.makeText(applicationContext,"Image Button clicked",Toast.LENGTH_LONG).show()
        }

        tglbtn.setOnClickListener {
            if(tglbtn.text.equals("OFF")){
                imgView.setImageResource(R.drawable.on)
            }else{
                imgView.setImageResource(R.drawable.off)
            }
        }

        fab.setOnClickListener {
            Toast.makeText(applicationContext,"Video call online",Toast.LENGTH_LONG).show()
        }

        var str : String
        var ch1 : CheckBox = findViewById(R.id.checkBox)
        var ch2 : CheckBox = findViewById(R.id.checkBox2)
        var ch3 : CheckBox = findViewById(R.id.checkBox3)
        var textview : TextView = findViewById(R.id.textView)

        ch1.setOnClickListener {
            str = "Java : ${ch1.isChecked}\nAndroid : ${ch2.isChecked}\nKotlin : ${ch3.isChecked}"
            textview.setText(str)
        }
        ch2.setOnClickListener {
            str = "Java : ${ch1.isChecked}\nAndroid : ${ch2.isChecked}\nKotlin : ${ch3.isChecked}"
            textview.setText(str)
        }
        ch3.setOnClickListener {
            str = "Java : ${ch1.isChecked}\nAndroid : ${ch2.isChecked}\nKotlin : ${ch3.isChecked}"
            textview.setText(str)
        }

        var rg : RadioGroup = findViewById(R.id.radiogroup)
        var tv2 : TextView = findViewById(R.id.textView2)
        var resetbtn : Button = findViewById(R.id.button2)

        rg.setOnCheckedChangeListener { radioGroup, i ->
            var rb = findViewById<RadioButton>(i)
            if(rb!=null){
                tv2.setText(rb.text)
            }
        }

        resetbtn.setOnClickListener {
            rg.clearCheck()
            tv2.setText("Select option")
        }
    }
}