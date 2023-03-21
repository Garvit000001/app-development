package com.example.contactmanagerappassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        Handler().postDelayed({
            val intent=Intent(this,signup::class.java)
            startActivity(intent)
            finish()//ab jab back karenge toh app band hoga intent nhi show hoga using finish
        },3000)



    }
}