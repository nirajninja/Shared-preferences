package com.example.shared_preference

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loaddata()
        btn1.setOnClickListener {
            saveData()
        }

    }



    private fun saveData()
    {
        val insertedText=etText.text.toString()
        textView.text=insertedText
        val sharedPref = getSharedPreferences("sharedPref",Context.MODE_PRIVATE)
        val editor=sharedPref.edit()
        editor.apply{
            putString("String_key",insertedText)
        }.apply()
        Toast.makeText(this,"saved",Toast.LENGTH_SHORT).show()
    }
    private fun loaddata() {
        val sharedPref=getSharedPreferences("sharedPref",Context.MODE_PRIVATE)
        val savedString=sharedPref.getString("String_key",null)
        textView.text=savedString
    }
}