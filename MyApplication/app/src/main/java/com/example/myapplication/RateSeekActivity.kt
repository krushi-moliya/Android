package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import android.widget.SeekBar
import android.widget.TextView

class RateSeekActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_seek)


        var ratingbar : RatingBar = findViewById(R.id.ratingBar)
        var tv : TextView = findViewById(R.id.textView3)

        ratingbar.setOnRatingBarChangeListener { ratingBar, fl, b ->
            tv.setText("RateBar Value: $fl")
        }

        var seekbar : SeekBar = findViewById(R.id.seekBar)
        var tv2 : TextView = findViewById(R.id.textView4)

        seekbar.setOnSeekBarChangeListener(object  : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                tv2.setText("SeekBar Value: $p1")
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
    }
}