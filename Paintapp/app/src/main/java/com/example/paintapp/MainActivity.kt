package com.example.paintapp

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.paintapp.PaintView.Companion.colorList
import com.example.paintapp.PaintView.Companion.currentBrush
import com.example.paintapp.PaintView.Companion.pathList
import kotlin.io.path.Path

class MainActivity : AppCompatActivity() {
    //drawing has two imp things with it one is path other is actual paint
    //for making it public in java we use public static but we dont have it in kotlin insteas we have companionobject
    companion object{
        var path= Path()
        var paintBrush=Paint()
        //we need this two things in paint.kt so inside companion object
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val redBtn=findViewById<ImageButton>(R.id.redColor)
        val blueBtn=findViewById<ImageButton>(R.id.blueColor)
        val blackBtn=findViewById<ImageButton>(R.id.blackColor)
        val eraser=findViewById<ImageButton>(R.id.whiteColor)

        redBtn.setOnClickListener{
            paintBrush.color = Color.RED
            currentColor(paintBrush.color)

        }
        blueBtn.setOnClickListener {
            paintBrush.color = Color.BLUE
            currentColor(paintBrush.color)



        }
        blackBtn.setOnClickListener {
            paintBrush.color = Color.BLACK
            currentColor(paintBrush.color)



        }
        eraser.setOnClickListener {
           pathList.clear()
            colorList.clear()
            path.reset()



        }
    }

    private fun currentColor(color:Int){
        currentBrush=color //so by this we are informing paintView class also that color has been changed
        //alo new color so new path is also to be created
        //path= new Path() this we write in java but in kotlin
        path=Path()
    }
}