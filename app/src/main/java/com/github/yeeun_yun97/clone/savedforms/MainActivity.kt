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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var submitButton: Button = findViewById(R.id.MainActivity_submitButton)
        submitButton.setOnClickListener {
            var intent = Intent(this, ErrorActivity::class.java)
            startActivity(intent)
        }
        initEmailForm()

        var emailDuplicateCheckButton: TextView = findViewById(R.id.mainActivity_emailDuplicateCheckButton)
        var emailEditText: EditText = findViewById(R.id.mainActivity_emailEditText)
        emailDuplicateCheckButton.setOnClickListener {
            Log.d("EditText",emailEditText.text.toString())
            setEmail(emailEditText.text.toString()) }

        if(savedInstanceState!=null){
            applySavedInstanceState(savedInstanceState)
        }
    }

    fun setEmail(email: String) {
        if (email.isEmpty()) {
            Log.d("TAG", "empty!")
        } else {
            setCheckedEmailTextview(email)
            hideEmailForm()
            Log.d("TAG", "work!")
        }
    }

    fun hideEmailForm() {
        var emailEditText: EditText = findViewById(R.id.mainActivity_emailEditText)
        var emailDuplicateCheckButton: TextView =
            findViewById(R.id.mainActivity_emailDuplicateCheckButton)
        emailEditText.setText("")
        emailEditText.visibility = View.GONE
        emailDuplicateCheckButton.visibility = View.GONE
    }

    fun setCheckedEmailTextview(email: String) {
        var emailCheckedTextview: TextView = findViewById(R.id.mainActivity_emailCheckedTextview)
        emailCheckedTextview.setText(email);
        emailCheckedTextview.visibility = View.VISIBLE
    }

    fun initEmailForm() {
        var emailEditText: EditText = findViewById(R.id.mainActivity_emailEditText)
        var emailCheckedTextview: TextView = findViewById(R.id.mainActivity_emailCheckedTextview)
        var emailDuplicateCheckButton: TextView =
            findViewById(R.id.mainActivity_emailDuplicateCheckButton)
        emailEditText.visibility = View.VISIBLE
        emailDuplicateCheckButton.visibility = View.VISIBLE
        emailCheckedTextview.visibility = View.GONE
    }

    fun applySavedInstanceState(savedInstanceState: Bundle) {
        var email:String = savedInstanceState.getString("email") ?: ""
        setEmail(email)
    }

    fun saveInstanceState(outState: Bundle){
        var EmailTextview: TextView = findViewById(R.id.mainActivity_emailCheckedTextview)
        if(!EmailTextview.text.isEmpty()) {
            outState.putString("email", EmailTextview.text.toString())
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("TAG","restore")
        applySavedInstanceState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("TAG","save")
        saveInstanceState(outState)
    }
}