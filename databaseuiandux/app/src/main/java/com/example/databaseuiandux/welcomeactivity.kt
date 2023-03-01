package com.example.databaseuiandux

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class welcomeactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcomeactivity)

        val mail=intent.getStringExtra(signinactivity.KEY1)
        val name=intent.getStringExtra(signinactivity.KEY2)
        val userId=intent.getStringExtra(signinactivity.KEY3)
        val welcomeText=findViewById<TextView>(R.id.tVWelcome)
        val mailText=findViewById<TextView>(R.id.tvMail)
        val idText=findViewById<TextView>(R.id.tvUnique)


        welcomeText.text= "Welcome$name"
        mailText.text= "Mail :$mail"
        idText.text= "UserId :$userId"



    }
}