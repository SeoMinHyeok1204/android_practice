package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        if(intent.hasExtra("msg")) {
            val msg : TextView = findViewById(R.id.getmsg)
            msg.text = intent.getStringExtra("msg")
        }

    }
}