package com.example.implicitintent

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webbutton = findViewById<CardView>(R.id.cardWeb)
        val camerabutton = findViewById<CardView>(R.id.cardcamera)

        webbutton.setOnClickListener{
            val intent=Intent(Intent.ACTION_VIEW)
            //vo action view hona chahiye user ko so data bhi denge
            intent.data= Uri.parse("https://9900riya.github.io/portfolio.github.io/")
            startActivity(intent)

        }
        camerabutton.setOnClickListener{
            val intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)//camera kholna h isliye mediastore m gye
            startActivity(intent)


        }

    }
}