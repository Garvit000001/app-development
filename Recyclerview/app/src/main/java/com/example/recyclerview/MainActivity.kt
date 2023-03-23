package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var myrecyclerview : RecyclerView

    lateinit var newsArrayList:ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myrecyclerview=findViewById(R.id.recycleView)
        val newsImageArray = arrayOf(
            R.drawable.pic0,
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5
        )
        val newsHeadingArray = arrayOf(
            "U.K. Foreign Secretary James Cleverly raises issue of BBC tax searches with EAM Jaishankar",
            "Cooking gas prices hiked by ₹50 for domestic, ₹350.50 for commercial cylinders",
            "Joe Biden appoints two prominent Indian-American corporate leaders to his Export Council",
            "Sergey Lavrov will raise suspected bombing of Nord Stream II at G20: Russian Foreign Ministry",
            "Belarusian leader Lukashenko visits China amid Ukraine tensions",
            "China rips new U.S. House committee on countering Beijing",
            "Largest gathering of Foreign Ministers hosted by any G20 presidency: Foreign Secretary Vinay Kwatra"
        )

        //layout manager is to set hav bhav of items inside recycler view,verticaly scrooliing ,horizontal scrooling,uniform grid
        myrecyclerview.layoutManager=LinearLayoutManager(this)

        newsArrayList= arrayListOf<News>()
        for(index in newsHeadingArray.indices){
            val news: News =News(newsHeadingArray[index],newsImageArray[index])
            newsArrayList.add(news)

        }

//        now we have created data and set everything else now to set adapter newsarraylist passes as it contains all data
            //and this is containing the context of activity we are talking about
        myrecyclerview.adapter=MyAdapter(newsArrayList,this)




    }
}