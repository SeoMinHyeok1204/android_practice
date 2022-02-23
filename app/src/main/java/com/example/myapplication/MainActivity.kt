package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!

    val users = arrayListOf<User>(
        User(R.drawable.pikachu, "서민혁", "22", "안녕하세요"),
        User(R.drawable.pikachu, "홍길동", "18", "반가워요"),
        User(R.drawable.pikachu, "전우치", "35", "잘 있어요"),
        User(R.drawable.pikachu, "김첨지", "13", "다시 만나요")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //binding.hello.setText("이게 된다구??")
        binding.button.setOnClickListener {
            var input = binding.inputText.text.toString()
            binding.hello.setText(input)
        }
        binding.buttonChange.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("msg", binding.hello.text.toString())
            finish()
            startActivity(intent)
        }
        var flag = 1
        binding.btnToast.setOnClickListener {
            Toast.makeText(this@MainActivity, "이것은 토스트 메시지$flag", Toast.LENGTH_SHORT).show()
            if(flag%2 == 1) {
                binding.image.setImageResource(R.drawable.android2)
                flag++
            }
            else {
                binding.image.setImageResource(R.drawable.android)
                flag++
            }
        }

//        val list = arrayOf("안녕하세요","반가워요","잘 있어요","다시 만나요")
//        binding.list.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_activated_1, list)
        val adapter = UserAdapter(this, users)
        binding.list.adapter = adapter

        binding.list.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selected = parent.getItemAtPosition(position) as User
            Toast.makeText(this, selected.name+" : "+selected.age, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}