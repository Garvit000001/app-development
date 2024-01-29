package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    //initiatlising 2d array of buttons
    private lateinit var board : Array<Array<Button>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Btn1=findViewById<Button>(R.id.Btn1)
        val Btn2=findViewById<Button>(R.id.Btn2)
        val Btn3=findViewById<Button>(R.id.Btn3)
        val Btn4=findViewById<Button>(R.id.Btn4)
        val Btn5=findViewById<Button>(R.id.Btn5)
        val Btn6=findViewById<Button>(R.id.Btn6)
        val Btn7=findViewById<Button>(R.id.Btn7)
        val Btn8=findViewById<Button>(R.id.Btn8)
        val Btn9=findViewById<Button>(R.id.Btn9)
        val resetBtn=findViewById<Button>(R.id.reset)

        board= arrayOf(
            arrayOf(Btn1,Btn2,Btn3),
            arrayOf(Btn4,Btn5,Btn6),
            arrayOf(Btn7,Btn8,Btn9)
        )

        for(i:Array<Button> in board){
            for(button:Button in i){
                button.setOnClickListener(this)
            }
        }
        resetBtn.setOnClickListener()
    }
}