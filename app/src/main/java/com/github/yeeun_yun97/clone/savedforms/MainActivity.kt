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
    private val submitButton by lazy { findViewById<Button>(R.id.MainActivity_submitButton) }
    private val emailDuplicateCheckButton by lazy { findViewById<Button>(R.id.mainActivity_emailDuplicateCheckButton) }
    private val emailEditText by lazy { findViewById<EditText>(R.id.mainActivity_emailEditText) }
    private val emailCheckedTextview by lazy { findViewById<TextView>(R.id.mainActivity_emailCheckedTextview) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        submitButton.setOnClickListener { startActivity(Intent(this, ErrorActivity::class.java)) }
        initEmailForm()
        emailDuplicateCheckButton.setOnClickListener { setEmail(emailEditText.text.toString()) }
        if (savedInstanceState != null) {
            restoreEmailString(savedInstanceState)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("TAG", "restore")
        restoreEmailString(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("TAG", "save")
        saveEmailString(outState)
    }

    private fun initEmailForm() {
        emailEditText.visibility = View.VISIBLE
        emailDuplicateCheckButton.visibility = View.VISIBLE
        emailCheckedTextview.visibility = View.GONE
    }

    private fun restoreEmailString(savedInstanceState: Bundle) {
        var email: String = savedInstanceState.getString("email") ?: ""
        setEmail(email)
    }

    private fun saveEmailString(outState: Bundle) {
        if (!emailCheckedTextview.text.isEmpty()) {
            outState.putString("email", emailCheckedTextview.text.toString())
        }
    }

    private fun setEmail(email: String) {
        if (email.isEmpty()) {
            Log.d("TAG", "empty!")
        } else {
            Log.d("TAG", "work!")
            setCheckedEmailTextview(email)
            hideEmailForm()
        }
    }

    private fun hideEmailForm() {
        emailEditText.setText("")
        emailEditText.visibility = View.GONE
        emailDuplicateCheckButton.visibility = View.GONE
    }

    private fun setCheckedEmailTextview(email: String) {
        emailCheckedTextview.setText(email);
        emailCheckedTextview.visibility = View.VISIBLE
    }
}