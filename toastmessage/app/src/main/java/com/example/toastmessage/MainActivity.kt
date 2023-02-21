package com.example.toastmessage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnUpload=findViewById<Button>(R.id.buttonUpload)
        val btnDownload=findViewById<Button>(R.id.buttonDownload)

        btnUpload.setOnClickListener{
            Toast.makeText(applicationContext,"Uploading...",Toast.LENGTH_SHORT).show()
        }
        btnDownload.setOnClickListener{
            Toast.makeText(applicationContext,"Downloading...",Toast.LENGTH_SHORT).show()
        }



    }
}