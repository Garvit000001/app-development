package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listview=findViewById<ListView>(R.id.listView)
        val tasklist= arrayListOf<String>()
        tasklist.add("Visit CP hanuman mandir")
        tasklist.add("Attend Exam")
        tasklist.add("Complete the app dev Project")
        tasklist.add("Buy Bhindi from market")
        tasklist.add("Work On resume")
        tasklist.add("Improve internet presence")

        //adapter is used to save data to listview
        //it is used to link data to listview
        val adapterformyListView=ArrayAdapter(this,android.R.layout.simple_list_item_1,tasklist)
        listview.adapter=adapterformyListView
        listview.setOnItemClickListener { parent, view, i, id ->
            //jo view h usme gettext jaisa method h hi nhi so humne implicit typecasting kari view ko TextView
            // ki tarah behave karvaya
            val text="Clicked on item :" + (view as TextView).text.toString()
            Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
        }




    }
}