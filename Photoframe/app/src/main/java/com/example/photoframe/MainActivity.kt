package com.example.photoframe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var currentImage=0

    lateinit var image: ImageView
    val names= arrayOf("Virat Kohli","Garvit","Ram","Pryinka Chopra")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val prev=findViewById<ImageButton>(R.id.imgPrev)
        val next=findViewById<ImageButton>(R.id.imgNext)
        val text=findViewById<TextView>(R.id.textView)

        prev.setOnClickListener{
            val idCurrentImageString= "pic$currentImage"
            //convert this string id to integer adress
            //we are writing code for finding R.id.imgprev value as we cannot use it direectly we need pure code
            val idCurrentImageInt=this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image=findViewById(idCurrentImageInt)
            image.alpha=0f

            currentImage=(currentImage-1+4)%4

            val idImageToShowString= "pic$currentImage"
            //convert this string id to integer adress
            //we are writing code for finding R.id.imgprev value as we cannot use it direectly we need pure code
            //we got it using this.getresources.getidentifier(idImageToShowString)
            val idImageToShowInt=this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image=findViewById(idImageToShowInt)
            image.alpha=1f
            //text.settext kar rhe hai
            text.text=names[currentImage]
        }
        next.setOnClickListener{
            val idCurrentImageString= "pic$currentImage"
            //convert this string id to integer adress
            //we are writing code for finding R.id.imgprev value as we cannot use it direectly we need pure code
            val idCurrentImageInt=this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image=findViewById(idCurrentImageInt)
            image.alpha=0f

            currentImage=(currentImage+1+4)%4

            val idImageToShowString= "pic$currentImage"
            //convert this string id to integer adress
            //we are writing code for finding R.id.imgprev value as we cannot use it direectly we need pure code
            //we got it using this.getresources.getidentifier(idImageToShowString)
            val idImageToShowInt=this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image=findViewById(idImageToShowInt)
            image.alpha=1f
            text.text=names[currentImage]

        }
    }
}