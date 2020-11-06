package com.learn.projectbootcamday1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SecondScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)
        val str = intent.getStringExtra("strA2b")
    }
}
