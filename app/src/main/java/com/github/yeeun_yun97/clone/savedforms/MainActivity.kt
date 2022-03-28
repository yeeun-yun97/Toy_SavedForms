package com.github.yeeun_yun97.clone.savedforms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val registerButton: Button by lazy{findViewById(R.id.MainActivity_registerButton)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerButton.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }


}