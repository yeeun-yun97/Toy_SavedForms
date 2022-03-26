package com.github.yeeun_yun97.clone.savedforms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ErrorActivity : AppCompatActivity() {
    private val backButton: Button by lazy{findViewById(R.id.errorActivity_errorButton)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error)

        backButton.setOnClickListener { this.onBackPressed() }
    }
}