package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        val heading=intent.getStringExtra("heading")
        val newsContent=intent.getStringExtra("newContent")
        val imageId=intent.getIntExtra("imageId",R.drawable.img1)

//        ye humne pichli page ya intent se li liya ab set bhi karna hai

        //so uske liye first findviewby id and then set

        val headingTV=findViewById<TextView>(R.id.newsHeading)
        val headingIV=findViewById<ImageView>(R.id.newsImage)
        val newsContentTV=findViewById<TextView>(R.id.newsContent)

        headingTV.text=heading
        headingIV.setImageResource(imageId)
        newsContentTV.text=newsContent






    }
}