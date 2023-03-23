package com.example.listviewproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var userarraylist: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = arrayOf("Saumya","Prastuti","ankit","Pradeep","Aman")
        val lastMsg=arrayOf("Hey everyone","I am fine","Good ","Awesome","Cool")
        val lastMsgTime=arrayOf("6:25 AM","7:30 PM","5:00 PM","6:25 AM","7:30 PM")
        val phoneNo= arrayOf("1234567790","1233567890","1238567890","1934567890","1134567890")
        val imageId= intArrayOf(R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5)

        userarraylist= ArrayList() //we have initialised our array list

        for(eachindex  in name.indices){
            val user=User(name[eachindex],lastMsg[eachindex], lastMsgTime[eachindex],
                phoneNo[eachindex],imageId[eachindex])
            userarraylist.add(user)
        }

         val listview=findViewById<ListView>(R.id.listview)
        listview.isClickable=true
//this matlab iss activity ka context kahan se aa rhe ho aur ja rhe hoo
        listview.adapter=Myadapter(this,userarraylist)








    }
}