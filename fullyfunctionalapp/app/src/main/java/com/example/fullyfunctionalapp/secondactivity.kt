package com.example.fullyfunctionalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class secondactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondactivity)

        val callbutton=findViewById<Button>(R.id.callbutton)
        callbutton.setOnClickListener{
            val intent=Intent(Intent.ACTION_CALL)
            startActivity(intent);
        }
    }
}