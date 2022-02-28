package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.*
import androidx.recyclerview.widget.RecyclerView
import java.security.Permission


class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        if(intent.hasExtra("msg")) {
            val msg : TextView = findViewById(R.id.getmsg)
            msg.text = intent.getStringExtra("msg")
        }

        loadData()

        val naver : Button = findViewById(R.id.btn_naver) // 네이버 열기
        naver.setOnClickListener {
            val intent = Intent(this, Naver::class.java)
            finish()
            startActivity(intent)
        }

        val profileArray = arrayListOf<Profiles>(
            Profiles(R.drawable.android, "서민혁", 22, "안녕하세요"),
            Profiles(R.drawable.android, "흥부", 30, "안녕"),
            Profiles(R.drawable.android, "놀부", 28, "안녕하세유"),
            Profiles(R.drawable.android, "심청", 19, "안녕하사와요"),
            Profiles(R.drawable.android, "두꺼비", 2, "두껍"),
            Profiles(R.drawable.android, "소재 고갈", 99, "?????")
        )

        val recycler : RecyclerView = findViewById(R.id.rv_profile)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.setHasFixedSize(true)
        recycler.adapter = ProfileAdapter(profileArray)
    }

    private fun saveData() {
        val pref = getSharedPreferences("pref", 0)
        val edit = pref.edit()
        val text : EditText= findViewById(R.id.et_hello)

        edit.putString("name", text.text.toString())
        edit.apply()
    }

    private fun loadData() {
        val pref = getSharedPreferences("pref", 0)
        val text : EditText = findViewById<EditText?>(R.id.et_hello)
        text.setText(pref.getString("name", "No Data Found"))
    }

    override fun onDestroy() {
        super.onDestroy()

        saveData()
    }
}