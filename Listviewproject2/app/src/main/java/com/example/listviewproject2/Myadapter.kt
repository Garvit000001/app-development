package com.example.listviewproject2

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

//array adapter jo builtin hota hai m chahta hoon ki hmara adappter usko bhi use kar paye hmara adapter
class Myadapter(private val context: Activity, val arrayList: ArrayList<User>) :
    ArrayAdapter<User>(context,R.layout.eachitem,R.id.tVlastMsg,arrayList
    ) {
//getview method is inside ArrayAdapter ie why we have extended it
    //aur humne iska use karke eachrow ko uthaya aur usme values dal di  name lastmsg etc
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//ie ab hum context se layout le rhe hai using below
        val inflater=LayoutInflater.from(context)
        //ie ab hum is inflater se view le rhe hai using below
        val view=inflater.inflate(R.layout.eachitem,null)

        val image=view.findViewById<CircleImageView>(R.id.profile_image)
        val name=view.findViewById<TextView>(R.id.tVName)
        val lastMsg=view.findViewById<TextView>(R.id.tVlastMsg)
        val lastMsgTime=view.findViewById<TextView>(R.id.tVLastMsgTime)


        name.text=arrayList[position].name
        lastMsg.text=arrayList[position].lastMsg
        lastMsgTime.text=arrayList[position].lastMsgTime
        image.setImageResource(arrayList[position].imageId)



        return super.getView(position, convertView, parent)
    }
}